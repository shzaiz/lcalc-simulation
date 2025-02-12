
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class Term {

    HashMap<String, Integer> freeVarMapCount = new HashMap<>();

    public enum TermType {
        ABSTRACT,
        APPLY,
        VARIABLE
    }

    public enum PosDecideType{
        NOT_DECIDED,
        DECIDING,
        DECIDED
    }

    protected TermType type;

    public Term(TermType t) {
        this.type = t;
    }

    public TermType getType() {
        return type;
    }

    // ----- Abstract methods replicating your Python code -----
    public abstract Term copy();
    public abstract String toString();
    public abstract Term replace(Variable var, Term term);
    public abstract boolean isVarIn(Variable var);
    public abstract List<Term> getAbstractVars();

    // One-step beta reduction
    // Return (newTerm, wasBetaReduced)
    public abstract ReductionResult oneStepBetaReduce();

    // One-step eta reduction
    // Return (newTerm, wasEtaReduced)
    public abstract ReductionResult oneStepEtaReduce();

    // For visually represent the lambda term
    Pair<Integer, Integer> startLocation = new Pair<>(0, 0);
    int length = 0;
    PosDecideType hasDecidedPos = PosDecideType.NOT_DECIDED;

    // Helpers for overall reduce
    public Term betaReduce(boolean verbose) {
        // Repeatedly do one-step beta
        Term current = this;
        int steps = 0;
        if(verbose) {
            System.out.println(steps + " -> " + current);
        }
        while(true) {
            ReductionResult rr = current.oneStepBetaReduce();
            if(!rr.wasReduced) {
                break;
            }
            current = rr.term;
            steps++;
            if(verbose) {
                System.out.println(steps + " -b> " + current.toString());
            }
        }
        return current;
    }

    public Term etaReduce(boolean verbose) {
        Term current = this;
        int steps = 0;
        if(verbose) {
            System.out.println(steps + " -> " + current);
        }
        while(true) {
            ReductionResult rr = current.oneStepEtaReduce();
            if(!rr.wasReduced) {
                break;
            }
            current = rr.term;
            steps++;
            if(verbose) {
                System.out.println(steps + " -e> " + current);
            }
        }
        return current;
    }

    // If both beta & eta are enabled
    public Term fullReduce(boolean verbose) {
        Term current = this;
        int steps = 0;
        if(verbose) {
            System.out.println(steps + " -> " + current);
        }
        while(true) {
            ReductionResult betaRR = current.oneStepBetaReduce();
            if(betaRR.wasReduced) {
                current = betaRR.term;
                steps++;
                if(verbose) {
                    System.out.println(steps + " b-> " + current);
                }
                continue;
            }
            // else try eta
            ReductionResult etaRR = current.oneStepEtaReduce();
            if(etaRR.wasReduced) {
                current = etaRR.term;
                steps++;
                if(verbose) {
                    System.out.println(steps + " e-> " + current);
                }
                continue;
            }
            break;
        }
        return current;
    }


    public static class ReductionResult {
        public Term term;
        public boolean wasReduced;

        public ReductionResult(Term t, boolean w) {
            term = t;
            wasReduced = w;
        }
    }

    public boolean alphaEquals(Term other) {
        // Implementation of alpha-equivalence can go here, if needed.
        return this.toString().equals(other.toString());
    }
}

// -------------- Variable --------------
class Variable extends Term {

    public String name;

    public Variable(String n) {
        super(TermType.VARIABLE);
        this.name = n;
    }

    @Override
    public List<Term> getAbstractVars() {
        // a single variable is not abstracted
        return new ArrayList<>();
    }

    @Override
    public Term copy() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Term replace(Variable var, Term term) {
        if(this == (var)) {
            // Replace current variable with 'term'
            return term.copy();
        }
        return this;
    }

    @Override
    public boolean isVarIn(Variable var) {
        return this == var;
    }

    @Override
    public ReductionResult oneStepBetaReduce() {
        // Variables do not beta-reduce by themselves
        return new ReductionResult(this, false);
    }

    @Override
    public ReductionResult oneStepEtaReduce() {
        // Variables do not eta-reduce by themselves
        return new ReductionResult(this, false);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Variable)) return false;
        return ((Variable)o).name.equals(this.name);
    }
}

// -------------- Abstract (λx.M) --------------
class Abstract extends Term {

    public Variable var;
    public Term body;

    public Abstract(Variable v, Term b) {
        // alpha conversion, variable renaming
        super(TermType.ABSTRACT);
        if(freeVarMapCount.containsKey(v.name)){
            int curr = freeVarMapCount.get(v.name);
            this.freeVarMapCount.put(v.name, curr+1);
        }else{
            freeVarMapCount.put(v.name, 0);
        }

        this.var = v;
        this.body = b;


    }

    @Override
    public Term copy() {
        // fresh copy of var, then replace occurrences
        Variable newVar = new Variable(var.name);
        // Recursively copy body, also rename var => newVar in body
        return new Abstract(newVar, body.replace(var, newVar));
    }

    @Override
    public String toString() {
        Optional<String> result = CheckRewrite.checkRewrite(this);
        if(result.isPresent()) return result.get();
        else return  "(λ" + var.name + "." + body.toString() + ")";
    }

    @Override
    public Term replace(Variable v, Term term) {
        // If same variable, skip
        if(this.var == v) {
            // Then occurrences in the body are "shadowed"
            return this.body.replace(v, term);
        }
        Term t = this.copy();
        // Otherwise, replace inside the body
        return new Abstract(((Abstract)t).var, ((Abstract) t).body.replace(v, term));
    }

    @Override
    public boolean isVarIn(Variable v) {
        return body.isVarIn(v);
    }

    @Override
    public List<Term> getAbstractVars() {
        // This and subchild
        body.getAbstractVars().add(var);
        return body.getAbstractVars();
    }

    @Override
    public ReductionResult oneStepBetaReduce() {
        // Beta-reduce inside the body
        ReductionResult rr = body.oneStepBetaReduce();
        if(rr.wasReduced) {
            return new ReductionResult(new Abstract(var, rr.term), true);
        }
        return new ReductionResult(this, false);
    }

    @Override
    public ReductionResult oneStepEtaReduce() {
        /*
           Eta rule: λx.(M x)  =>  M
           if x not in M (free)
        */
        // body should be an Apply(M, x), and x not free in M
        if(body instanceof Apply) {
            Apply app = (Apply) body;
            if(app.right instanceof Variable) {
                Variable rightVar = (Variable) app.right;
                if(rightVar == (var)) {
                    // check if var is not free in app.left
                    if(!app.left.isVarIn(var)) {
                        // then eta-reduce
                        return new ReductionResult(app.left, true);
                    }
                }
            }
        }
        // Otherwise, try inside the body
        ReductionResult rr = body.oneStepEtaReduce();
        if(rr.wasReduced) {
            return new ReductionResult(new Abstract(var, rr.term), true);
        }
        return new ReductionResult(this, false);
    }
}

// -------------- Apply (M N) --------------
class Apply extends Term {

    public Term left;
    public Term right;

    public Apply(Term l, Term r) {
        super(TermType.APPLY);
        this.left = l;
        this.right = r;
    }

    @Override
    public Term copy() {
        return new Apply(left.copy(), right.copy());
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + right.toString() + ")";
    }

    @Override
    public Term replace(Variable v, Term t) {
        return new Apply(left.replace(v, t), right.replace(v, t));
    }

    @Override
    public boolean isVarIn(Variable v) {
        return left.isVarIn(v) || right.isVarIn(v);
    }

    @Override
    public List<Term> getAbstractVars() {
         left.getAbstractVars().addAll(right.getAbstractVars());
         return left.getAbstractVars();
    }

    @Override
    public ReductionResult oneStepBetaReduce() {
        // If left is an Abstract, do substitution (β-reduction)
        if(left instanceof Abstract) {
            Abstract abs = (Abstract) left;
            // (λx.M) N => M[x := N]
            Term replaced = abs.body.replace(abs.var, right);
            return new ReductionResult(replaced, true);
        }
        // Otherwise, try to beta-reduce left
        ReductionResult rrLeft = left.oneStepBetaReduce();
        if(rrLeft.wasReduced) {
            return new ReductionResult(new Apply(rrLeft.term, right), true);
        }
        // Otherwise, try to beta-reduce right
        ReductionResult rrRight = right.oneStepBetaReduce();
        if(rrRight.wasReduced) {
            return new ReductionResult(new Apply(left, rrRight.term), true);
        }
        // No beta-reduction possible
        return new ReductionResult(this, false);
    }

    @Override
    public ReductionResult oneStepEtaReduce() {
        // Try left
        ReductionResult rrLeft = left.oneStepEtaReduce();
        if(rrLeft.wasReduced) {
            return new ReductionResult(new Apply(rrLeft.term, right), true);
        }
        // Otherwise, try right
        ReductionResult rrRight = right.oneStepEtaReduce();
        if(rrRight.wasReduced) {
            return new ReductionResult(new Apply(left, rrRight.term), true);
        }
        return new ReductionResult(this, false);
    }
}
