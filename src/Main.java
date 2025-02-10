
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            if(args.length > 0) {
                // parse file
                String filename = args[0];
                InputStream is = Files.newInputStream(Paths.get(filename));
                CharStream input = CharStreams.fromStream(is);
                LEvalLexer lexer = new LEvalLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LEvalParser parser = new LEvalParser(tokens);

                ParseTree tree = parser.program();
                LEvalVisitorImpl visitor = new LEvalVisitorImpl();
                visitor.visit(tree);
            }
            else {
                // interactive mode
                System.out.println("Lambda Simulator v1.0 (Java) - Type 'exit;' to quit, 'help;' for help.");
                LEvalVisitorImpl visitor = new LEvalVisitorImpl();
                Scanner sc = new Scanner(System.in);
                String buffer = "";
                boolean newInput = true;

                while(true) {
                    if(newInput) {
                        System.out.print("> ");
                    }
                    else {
                        System.out.print("... ");
                    }
                    String line = sc.nextLine();

                    // Accumulate until we see a semicolon
                    buffer += line;
                    if(line.trim().endsWith(";")) {
                        // parse the buffer
                        CharStream input = CharStreams.fromString(buffer);
                        LEvalLexer lexer = new LEvalLexer(input);
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        LEvalParser parser = new LEvalParser(tokens);

                        try {
                            ParseTree tree = parser.program();
                            visitor.visit(tree);
                        } catch(RuntimeException ex) {
                            System.err.println("Error: " + ex.getMessage());
                        }
                        buffer = "";
                        newInput = true;
                    } else {
                        newInput = false;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
