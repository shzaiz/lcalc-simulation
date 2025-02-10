// Generated from LEval.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LEvalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LEvalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LEvalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LEvalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(LEvalParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#booleanOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOption(LEvalParser.BooleanOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#reduceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReduceOption(LEvalParser.ReduceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#latexExportOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLatexExportOptions(LEvalParser.LatexExportOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LEvalParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#application}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(LEvalParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#rExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRExpr(LEvalParser.RExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#eExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEExpr(LEvalParser.EExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#lambdaVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaVars(LEvalParser.LambdaVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#tupleElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleElements(LEvalParser.TupleElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LEvalParser#listElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListElements(LEvalParser.ListElementsContext ctx);
}