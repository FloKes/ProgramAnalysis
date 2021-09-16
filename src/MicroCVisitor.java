// Generated from C:/Users/musta/OneDrive/Project-folder DTU/7 semester/Program Analysis/Program-Analysis-DTU-Fall-21\MicroC.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by {@link MicroCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MicroCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#lexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr(MicroCParser.LexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#rexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexpr(MicroCParser.RexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(MicroCParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpr(MicroCParser.BexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroCParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MicroCParser.DeclContext ctx);
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