import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LEvalVisitorImpl extends LEvalBaseVisitor<Term> {

    // Free variables map: varName -> (Term, isRecursive?)
    private Map<String,Term> freeVars = new HashMap<>();

    // The default fixed-point combinator
    private Term combinator = createTuringCombinator();

    // Some flags:
    private boolean verbose = false;
    private boolean reduceBeta = true;
    private boolean reduceEta  = false;

    // For tracking stats
    private long lastReductionSteps = 0;
    private double lastEvalTime = 0.0;

    // Top-level entry
    @Override
    public Term visitProgram(LEvalParser.ProgramContext ctx) {
        // Each child is basically "instruction ;"
        // But we can just visit children
        return visitChildren(ctx);
    }

    // Each instruction is handled
    @Override
    public Term visitInstruction(LEvalParser.InstructionContext ctx){
        // We check which alternative matched
        if(ctx.HELP() != null) {
            // help;
            doHelp();
        }
        else if(ctx.CLEAR() != null) {
            // clear;
            doClear();
        }
        else if(ctx.EXIT() != null) {
            // exit;
            doExit();
        }
        else if(ctx.LISTALL() != null) {
            // listall;
            doListAll();
        }
        else if(ctx.SHOWLASTINFOS() != null) {
            // showlastinfo;
            doShowLastInfos();
        }
        else if(ctx.VERBOSE() != null) {
            boolean b = ctx.booleanOption().TRUE_() != null;
            this.verbose = b;
        }
        else if(ctx.REDUCE() != null) {
            setReduceOptions(ctx.reduceOption());
        }
        else if(ctx.PRINT() != null) {
            Term t = visitTerm(ctx.term());
            Term result = evalTerm(t);
            System.out.println(formatTerm(result));
        }
        else if(ctx.PRINTNOEVAL() != null) {
            Term t = visitTerm(ctx.term());
            System.out.println(formatTerm(t));
        }
        else if(ctx.IMPORT() != null) {
            String path = stripQuotes(ctx.STRING().getText());
            try {
                doImport(path);
            } catch (IOException e) {
                System.err.println("Error while reading file!");
            }
        }
        else if(ctx.DEFAULTCOMBINATOR() != null) {
            Term t = visitTerm(ctx.term());
            this.combinator = t;
        }
        else if(ctx.NAME() != null && (ctx.ASSIGN() != null || ctx.ASSIGN_NO_EVAL() != null)) {
            // Assignment
            String varName = ctx.NAME().getText();
            boolean noEval = (ctx.ASSIGN_NO_EVAL() != null);
            Term rightTerm = visitTerm(ctx.term());
            // Evaluate or not
            if(!noEval) {
                rightTerm = evalTerm(rightTerm);
            }
            // Store
            freeVars.put(varName, rightTerm);
        }
        return null;
    }

    // Evaluate a Term under the user-chosen strategy
    private Term evalTerm(Term t) {
        long start = System.nanoTime();
        Term result;
        if(reduceBeta && reduceEta) {
            result = t.fullReduce(verbose);
        } else if(reduceBeta) {
            result = t.betaReduce(verbose);
        } else if(reduceEta) {
            result = t.etaReduce(verbose);
        } else {
            // no reduction
            result = t;
        }
        long end = System.nanoTime();
        this.lastEvalTime = (end - start) / 1e9;
        return result;
    }

    // Build a Term from the parse tree
    // This is the key for the expression-building logic
    @Override
    public Term visitTerm(LEvalParser.TermContext ctx) {
        // We forward to application rule
        return visitApplication(ctx.application());
    }

    @Override
    public Term visitApplication(LEvalParser.ApplicationContext ctx) {
        // application -> rExpr (rExpr)*
        List<LEvalParser.RExprContext> rlist = ctx.rExpr();
        // T -> R { R* } => left-associative
        // We parse the first R, then apply subsequent R’s
        Term current = visitRExpr(rlist.get(0));
        for(int i=1; i<rlist.size(); i++){
            Term next = visitRExpr(rlist.get(i));
            current = new Apply(current, next);
        }
        return current;
    }

    @Override
    public Term visitRExpr(LEvalParser.RExprContext ctx) {
        /*
         R -> E | E :: R
         If there's a ":: R", we convert to a "list pile" structure:
         Or in your Python code, you handle it as "list_pile(e, r)"?
         Actually the Python code has "E :: R" => a special list-liker.
        */
        Term left = visitEExpr(ctx.eExpr());
        if(ctx.rExpr() != null) {
            // means we have E :: R
            Term right = visitRExpr(ctx.rExpr());
            // "E :: R" => cons-like structure, or your "list_pile"
            return listPile(left, right);
        } else {
            return left;
        }
    }

    @Override
    public Term visitEExpr(LEvalParser.EExprContext ctx) {
        /*
         E -> (term)
            | NAME
            | NUMBER
            | LAMBDA (NAME+) DOT term
            | < term (, term)* >
            | [ term (, term)* ] | []
        */
        if(ctx.LPAREN() != null) {
            return visitTerm(ctx.term());
        }
        if(ctx.NAME() != null) {
            String n = ctx.NAME().getText();
            // If it's in freeVars, return a copy
            if(freeVars.containsKey(n)) {
                return freeVars.get(n).copy();
            } else {
                // Treat as a variable
                return new Variable(n);
            }
        }
        if(ctx.NUMBER() != null) {
            int val = Integer.parseInt(ctx.NUMBER().getText());
            return genNumber(val);
        }
        if(ctx.LAMBDA() != null) {
            // λ (NAME+) . term
            List<TerminalNode> vars = ctx.lambdaVars().NAME();
            // build from right to left
            Term body = visitTerm(ctx.term());
            for(int i=vars.size()-1; i>=0; i--) {
                Variable v = new Variable(vars.get(i).getText());
                body = new Abstract(v, body);
            }
            return body;
        }
        if(ctx.LCHEVRON() != null) {
            // < term (, term)* >
            List<LEvalParser.TermContext> terms = ctx.tupleElements().term();
            ArrayList<Term> list = new ArrayList<>();
            for(LEvalParser.TermContext tc : terms) {
                list.add(visitTerm(tc));
            }
            return genTuple(list);
        }
        if(ctx.LBRACK() != null) {
            // [] or [term (, term)*]
            if(ctx.listElements() == null) {
                // empty list
                return genList(new ArrayList<>());
            } else {
                List<LEvalParser.TermContext> terms = ctx.listElements().term();
                ArrayList<Term> list = new ArrayList<>();
                for(LEvalParser.TermContext tc : terms) {
                    list.add(visitTerm(tc));
                }
                return genList(list);
            }
        }
        // should not happen if grammar is correct
        throw new RuntimeException("Unknown EExpr form");
    }

    // ---------- Helper methods for building typical Church encodings ----------
    private Term genNumber(int n) {
        // Church numeral: λf. λx. f^n(x)
        Variable f = new Variable("f");
        Variable x = new Variable("x");
        Term body = x;
        for(int i=0; i<n; i++){
            body = new Apply(f, body);
        }
        return new Abstract(f, new Abstract(x, body));
    }

    private Term genTuple(List<Term> list) {
        // a tuple <t1, t2, ..., tn> => λx. x t1 t2 ... tn
        Variable x = new Variable("x");
        Term body = x;
        // The order is reversed because you do x tN ... t2 t1 if you do normal left app
        for(int i=0; i<list.size(); i++){
            body = new Apply(body, list.get(i));
        }
        return new Abstract(x, body);
    }

    // "list pile" => λx. λy. x head tail
    private Term listPile(Term h, Term t) {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        // return λx. λy. (x h t)
        return new Abstract(x, new Abstract(y, new Apply(new Apply(x, h), t)));
    }

    private Term genList(List<Term> arr) {
        // A list: fold from right with empty as λx. λy. y
        // empty => λx. λy. y
        Term empty = new Abstract(new Variable("x"),
                new Abstract(new Variable("y"),
                        new Variable("y")));
        Term result = empty;
        // fold right
        for(int i=arr.size()-1; i>=0; i--){
            Term head = arr.get(i);
            result = listPile(head, result);
        }
        return result;
    }

    // ---------- Combinators -----------
    // Turing fixed-point combinator from your code
    private Term createTuringCombinator() {
        /*
           Y = (λa. λb. b (a a b)) (λa. λb. b (a a b))
           We'll do something like that in Java
        */
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Term part = new Abstract(a,
                new Abstract(b,
                        new Apply(
                                new Variable("b"),
                                new Apply(
                                        new Apply(new Variable("a"), new Variable("a")),
                                        new Variable("b")
                                )
                        )
                )
        );
        return new Apply(part, part.copy());
    }

    // ---------- Implementation details for instructions ----------
    private void doHelp() {
        System.out.println("----------- BASICS -----------");
        System.out.println("print TERM; -> evaluate and display");
        System.out.println("printnoeval TERM; -> parse but do not evaluate");
        System.out.println("NAME := TERM; -> assign evaluated term to variable");
        System.out.println("NAME <- TERM; -> assign term without evaluating");
        System.out.println("listall; -> list defined variables");
        System.out.println("exit; -> quit interpreter");
    }

    private void doClear() {
        // Clear screen hack
        // This is system-dependent; you can adapt or remove.
        try {
            if(System.getProperty("os.name").toLowerCase().contains("windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\u001b[H\u001b[2J");
                System.out.flush();
            }
        } catch(Exception e) {}
    }

    private void doExit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private void doListAll() {
        for(String k : freeVars.keySet()) {
            System.out.println(k + " -> " + freeVars.get(k));
        }
    }

    private void doShowLastInfos() {
        System.out.println("Last evaluation time: " + lastEvalTime + "s");
        System.out.println("Last reduction steps: " + lastReductionSteps);
    }

    private void setReduceOptions(LEvalParser.ReduceOptionContext ctx) {
        if(ctx.BETA() != null) {
            reduceBeta = true;
            reduceEta  = false;
        } else if(ctx.ETA() != null) {
            reduceEta  = true;
            reduceBeta = false;
        } else if(ctx.BOTH() != null) {
            reduceEta  = true;
            reduceBeta = true;
        }
    }

    private void doImport(String path) throws IOException {
        System.out.println("Importing file: " + path + "...");
        CharStream input = CharStreams.fromStream(Files.newInputStream(Paths.get(path)));
        LEvalLexer lexer = new LEvalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LEvalParser parser = new LEvalParser(tokens);

        try {
            ParseTree tree = parser.program();
            Main.visitor.visit(tree);
        } catch(RuntimeException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }



    // Utility: remove surrounding quotes from the parse text
    private String stripQuotes(String s) {
        if(s.startsWith("\"") && s.endsWith("\"") && s.length()>=2) {
            return s.substring(1, s.length()-1);
        }
        return s;
    }

    // A simplified term -> string representation
    // to detect Church numerals, lists.
    private String formatTerm(Term t) {
        Optional<String> str = CheckRewrite.checkRewrite(t);
        return str.orElseGet(t::toString);
    }
}
