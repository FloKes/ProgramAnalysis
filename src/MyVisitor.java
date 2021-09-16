//based on tutorial: https://www.youtube.com/watch?v=dPWWcH5uM0g

public class MyVisitor extends MicroCBaseVisitor {

    @Override
    public Object visitProgram(MicroCParser.ProgramContext ctx) {

        System.out.println("Inside Program rule");

        return visitChildren(ctx);

    }

    @Override
    public Object visitStatement(MicroCParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitLexpr(MicroCParser.LexprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRexpr(MicroCParser.RexprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitArray(MicroCParser.ArrayContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBexpr(MicroCParser.BexprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDecl(MicroCParser.DeclContext ctx) { return visitChildren(ctx); }

    @Override public Object visitOpa(MicroCParser.OpaContext ctx) { return visitChildren(ctx); }

    @Override public Object visitOpr(MicroCParser.OprContext ctx) { return visitChildren(ctx); }

    @Override public Object visitOpb(MicroCParser.OpbContext ctx) { return visitChildren(ctx); }
}
