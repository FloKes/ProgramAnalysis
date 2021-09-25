// Generated from C:/Users/giaco/IdeaProjects/Program-Analysis/src/antlr\MicroC.g4 by ANTLR 4.9.1
package antlr;
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
	 * Enter a parse tree produced by {@link MicroCParser#blockStmnt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmnt(MicroCParser.BlockStmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#blockStmnt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmnt(MicroCParser.BlockStmntContext ctx);
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
	 * Enter a parse tree produced by {@link MicroCParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(MicroCParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(MicroCParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#elseStmnt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmnt(MicroCParser.ElseStmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#elseStmnt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmnt(MicroCParser.ElseStmntContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#lAssign}.
	 * @param ctx the parse tree
	 */
	void enterLAssign(MicroCParser.LAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#lAssign}.
	 * @param ctx the parse tree
	 */
	void exitLAssign(MicroCParser.LAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#recordAssign}.
	 * @param ctx the parse tree
	 */
	void enterRecordAssign(MicroCParser.RecordAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#recordAssign}.
	 * @param ctx the parse tree
	 */
	void exitRecordAssign(MicroCParser.RecordAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#whileStmnt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmnt(MicroCParser.WhileStmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#whileStmnt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmnt(MicroCParser.WhileStmntContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#readStmnt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmnt(MicroCParser.ReadStmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#readStmnt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmnt(MicroCParser.ReadStmntContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#writeStmnt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmnt(MicroCParser.WriteStmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#writeStmnt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmnt(MicroCParser.WriteStmntContext ctx);
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
	 * Enter a parse tree produced by {@link MicroCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MicroCParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MicroCParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(MicroCParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(MicroCParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#recordDecl}.
	 * @param ctx the parse tree
	 */
	void enterRecordDecl(MicroCParser.RecordDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#recordDecl}.
	 * @param ctx the parse tree
	 */
	void exitRecordDecl(MicroCParser.RecordDeclContext ctx);
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