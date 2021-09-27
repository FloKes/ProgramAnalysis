package microC;

import antlr.MicroCBaseVisitor;
import antlr.MicroCParser;

import javax.swing.plaf.nimbus.State;

public class ASTBuilderVisitor extends MicroCBaseVisitor<AbstractNode> {

    @Override
    public AbstractNode visitProgram(MicroCParser.ProgramContext ctx) {
        Program prog = new Program();
        for (var a : ctx.children) {
            if (a instanceof MicroCParser.DeclContext){
                prog.setDeclNode((Declaration) visit(a));
            }
            else if(a instanceof MicroCParser.StatementContext){
                prog.setStatementNode((Statement) visit(a));
            }
        }
        return prog;
    }

    @Override
    public AbstractNode visitStatement(MicroCParser.StatementContext ctx) {
        var statement =  new Statement();
        for (var a : ctx.children) {
            if (a instanceof MicroCParser.IfElseContext) {

            }
            else if(a instanceof MicroCParser.LAssignContext) {

            }
            else if(a instanceof MicroCParser.RecordAssignContext) {

            }
            else if(a instanceof MicroCParser.WhileStmntContext) {
                statement.addWhileStatement((Statement) visit(a));
            }

            else if(a instanceof MicroCParser.ArrayDeclContext){

            }
            else if(a instanceof MicroCParser.RecordDeclContext){

            }
            else if(a instanceof MicroCParser.ReadStmntContext) {
                statement.addReadStatement((Statement) visit(a));
            }
            else if(a instanceof MicroCParser.WriteStmntContext) {
                statement.addWriteStatement((Statement) visit(a));
            }
        }
        return statement;
    }

    @Override
    public AbstractNode visitReadStmnt(MicroCParser.ReadStmntContext ctx) {
        return new ReadStatement(
                (Lexpression) visit(ctx.lexpr())
                );
    }

    @Override
    public AbstractNode visitWriteStmnt(MicroCParser.WriteStmntContext ctx) {
        return new WriteStatement(
                (Rexpression) visit(ctx.rexpr())
                );
    }

    @Override
    public AbstractNode visitWhileStmnt(MicroCParser.WhileStmntContext ctx) {
            return new WhileDeclaration(
                (Bexpression) visit(ctx.bexpr()),
                (BlockStatement) visit(ctx.blockStmnt()));
    }


    @Override
    public AbstractNode visitDecl(MicroCParser.DeclContext ctx) {
        var declNode = new Declaration();

        for (var a : ctx.children) {
            if (a instanceof MicroCParser.VarDeclContext){
                declNode.addVarDecl((VariableDeclaration) visit(a));
            }
            else if(a instanceof MicroCParser.ArrayDeclContext){
                declNode.addArrDecl((ArrayDeclaration) visit(a));
            }
            else if(a instanceof MicroCParser.RecordDeclContext){
                declNode.addRecDecl((RecordDeclaration) visit(a));

            }
        }
        return declNode;
    }

    @Override
    public AbstractNode visitVarDecl(MicroCParser.VarDeclContext ctx) {
        if(ctx.INTEGER() != null){
            return new VariableDeclaration(
                    ctx.IDENTIFIER().getText(),
                    ctx.INT().getText(),
                    Integer.parseInt(ctx.INTEGER().getText()));
        }

        return new VariableDeclaration(
                ctx.IDENTIFIER().getText(),
                ctx.INT().getText());
    }

    @Override
    public AbstractNode visitArrayDecl(MicroCParser.ArrayDeclContext ctx) {
        return new ArrayDeclaration(
                Integer.parseInt(ctx.INTEGER().getText()),
                ctx.INT().getText(),
                ctx.IDENTIFIER().getText()
        );
    }

    @Override
    public AbstractNode visitRecordDecl(MicroCParser.RecordDeclContext ctx) {
        return super.visitRecordDecl(ctx);
    }
}
