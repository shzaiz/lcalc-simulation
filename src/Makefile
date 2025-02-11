antlr: LEval.g4
	antlr4 -visitor -no-listener LEval.g4

clean:
	rm LEval.interp
	rm LEval.tokens
	rm LEvalBaseVisitor.java
	rm LEvalLexer.java
	rm LEvalLexer.interp
	rm LEvalLexer.tokens
	rm LEvalVisitor.java
	rm LEvalParser.java

run: CheckRewrite.java Main.java Term.java
