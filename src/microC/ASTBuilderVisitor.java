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
            if (a instanceof MicroCParser.IfElseContext){
                statement.AddIfElse((IfElseNode) visit(a));
            }
            else if(a instanceof MicroCParser.LAssignContext){
                statement.AddLAssign((LAssignNode) visit(a));
            }
            else if(a instanceof MicroCParser.RecordAssignContext){
            }
            else if(a instanceof MicroCParser.WhileStmntContext){
            }
            else if(a instanceof MicroCParser.ReadStmntContext){
            }
            else if(a instanceof MicroCParser.WriteStmntContext){

            }
        }
        return statement;
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
        return new RecordDeclaration(
                (VariableDeclaration) visit(ctx.varDecl(0)),
                (VariableDeclaration) visit(ctx.varDecl(1))
        );
    }

    @Override
    public AbstractNode visitIfElse(MicroCParser.IfElseContext ctx) {
        if(ctx.elseStmnt() != null){
            return new IfElseNode(
                    (BooleanExprNode) visit(ctx.bexpr()),
                    (BlockNode) visit(ctx.blockStmnt()),
                    (ElseNode) visit(ctx.elseStmnt())
            );
        }
        return new IfElseNode(
                (BooleanExprNode) visit(ctx.bexpr()),
                (BlockNode) visit(ctx.blockStmnt())
        );
    }

    @Override
    public AbstractNode visitElseStmnt(MicroCParser.ElseStmntContext ctx) {
        return new ElseNode((BlockNode) visit(ctx.blockStmnt()));
    }

    @Override
    public AbstractNode visitLAssign(MicroCParser.LAssignContext ctx) {
        return new LAssignNode(
                (LExprNode) visit(ctx.lexpr()),
                (RExprNode) visit(ctx.rexpr())
        );
    }


    @Override
    public AbstractNode visitArray(MicroCParser.ArrayContext ctx) {
        if(ctx.IDENTIFIER() != null){
            return new ArrayIndexNode<>(ctx.IDENTIFIER().getText());
        }
        return new ArrayIndexNode<>(Integer.parseInt(ctx.INTEGER().getText()));
    }

    @Override
    public AbstractNode visitVarIdentifier(MicroCParser.VarIdentifierContext ctx) {
        return new LExprVarIdNode(ctx.IDENTIFIER().getText());
    }

    @Override
    public AbstractNode visitArrayIndexId(MicroCParser.ArrayIndexIdContext ctx) {
        return new LExprArrayIdNode(ctx.IDENTIFIER().getText(), (ArrayIndexNode) visit(ctx.array()));
    }


    @Override
    public AbstractNode visitRecFst(MicroCParser.RecFstContext ctx) {
        return new RecAccessNode(RecAccessEnum.FST, ctx.FST().getText());
    }

    @Override
    public AbstractNode visitRecSnd(MicroCParser.RecSndContext ctx) {
        return new RecAccessNode(RecAccessEnum.SND, ctx.SND().getText());
    }

    @Override
    public AbstractNode visitRexpr(MicroCParser.RexprContext ctx) {
        return super.visitRexpr(ctx);
    }

    @Override
    public AbstractNode visitRecordAssign(MicroCParser.RecordAssignContext ctx) {
        return super.visitRecordAssign(ctx);
    }
}
