// Generated from C:/Users/flori/Desktop/Autumn 21/Program Analysis/Parser/Program-Analysis-DTU-Fall-21/src/antlr\MicroC.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MicroCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MicroCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#blockStmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmnt(MicroCParser.BlockStmntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MicroCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#ifElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(MicroCParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#elseStmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmnt(MicroCParser.ElseStmntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#lAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAssign(MicroCParser.LAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#recordAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordAssign(MicroCParser.RecordAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#whileStmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmnt(MicroCParser.WhileStmntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#readStmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmnt(MicroCParser.ReadStmntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#writeStmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmnt(MicroCParser.WriteStmntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#identifierExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(MicroCParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueIdentifier}
	 * labeled alternative in {@link MicroCParser#valueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueIdentifier(MicroCParser.ValueIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueNumber}
	 * labeled alternative in {@link MicroCParser#valueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueNumber(MicroCParser.ValueNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vexprOpAvexpr}
	 * labeled alternative in {@link MicroCParser#valueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVexprOpAvexpr(MicroCParser.VexprOpAvexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#recFst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecFst(MicroCParser.RecFstContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#recSnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecSnd(MicroCParser.RecSndContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#varIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarIdentifier(MicroCParser.VarIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#arrayIndexId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndexId(MicroCParser.ArrayIndexIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MicroCParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseTerm}
	 * labeled alternative in {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseTerm(MicroCParser.FalseTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bexprOpBbexpr}
	 * labeled alternative in {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexprOpBbexpr(MicroCParser.BexprOpBbexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueTerm}
	 * labeled alternative in {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueTerm(MicroCParser.TrueTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vexprOpRvexpr}
	 * labeled alternative in {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVexprOpRvexpr(MicroCParser.VexprOpRvexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notBexpr}
	 * labeled alternative in {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotBexpr(MicroCParser.NotBexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MicroCParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MicroCParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(MicroCParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#recordDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDecl(MicroCParser.RecordDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#opa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpa(MicroCParser.OpaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpr(MicroCParser.OprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#opb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpb(MicroCParser.OpbContext ctx);
}