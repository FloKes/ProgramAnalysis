// Generated from C:/Users/musta/OneDrive/Project-folder DTU/7 semester/Program Analysis/Program-Analysis-DTU-Fall-21\MicroC.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MicroCParser}.
 */
public interface MicroCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MicroCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MicroCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#lexpr}.
	 * @param ctx the parse tree
	 */
	void enterLexpr(MicroCParser.LexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#lexpr}.
	 * @param ctx the parse tree
	 */
	void exitLexpr(MicroCParser.LexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#rexpr}.
	 * @param ctx the parse tree
	 */
	void enterRexpr(MicroCParser.RexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#rexpr}.
	 * @param ctx the parse tree
	 */
	void exitRexpr(MicroCParser.RexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(MicroCParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(MicroCParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterBexpr(MicroCParser.BexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitBexpr(MicroCParser.BexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MicroCParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MicroCParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#opa}.
	 * @param ctx the parse tree
	 */
	void enterOpa(MicroCParser.OpaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#opa}.
	 * @param ctx the parse tree
	 */
	void exitOpa(MicroCParser.OpaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOpr(MicroCParser.OprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOpr(MicroCParser.OprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#opb}.
	 * @param ctx the parse tree
	 */
	void enterOpb(MicroCParser.OpbContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#opb}.
	 * @param ctx the parse tree
	 */
	void exitOpb(MicroCParser.OpbContext ctx);
}