package microC;

import antlr.MicroCBaseVisitor;
import antlr.MicroCParser;
import microC.Declaration.*;
import microC.Expressions.*;
import microC.Statement.*;

public class ASTBuilderVisitor extends MicroCBaseVisitor<AbstractNode> {

    @Override
    public AbstractNode visitProgram(MicroCParser.ProgramContext ctx) {
        ProgramNode prog = new ProgramNode();
        prog.addDecl((Declarations) visit(ctx.decl()));
        prog.addStatement((Statements) visit(ctx.statement()));

        return prog;
    }

    @Override
    public AbstractNode visitStatement(MicroCParser.StatementContext ctx) {
        var statements = new Statements();
        for (var a : ctx.children) {
            statements.addStatement((Statement) visit(a));
        }
        return statements;
    }

    @Override
    public AbstractNode visitReadStmnt(MicroCParser.ReadStmntContext ctx) {
        return new ReadStatement(
                (IdentifierExpressionNode) visit(ctx.identifierExpr())
                );
    }

    @Override
    public AbstractNode visitWriteStmnt(MicroCParser.WriteStmntContext ctx) {
        return new WriteStatement(
                (ExpressionNode) visit(ctx.valueExpr())
                );
    }

    @Override
    public AbstractNode visitWhileStmnt(MicroCParser.WhileStmntContext ctx) {
            return new WhileDeclaration(
                    (BooleanExpressionNode) visit(ctx.bexpr()),
                (BlockNode) visit(ctx.blockStmnt()));
    }

    @Override
    public AbstractNode visitBlockStmnt(MicroCParser.BlockStmntContext ctx) {
        var block = new BlockNode();
        if (ctx.decl() != null) {
            block.addDecl((Declarations) visit(ctx.decl()));
        }
        if (ctx.statement() != null) {
            block.addStatement((Statements) visit(ctx.statement()));
        }

        return block;
    }

    @Override
    public AbstractNode visitDecl(MicroCParser.DeclContext ctx) {
        var decls = new Declarations();

        for (var a : ctx.children) {
            decls.addDecl((Declaration) visit(a));
        }
        return decls;
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
                (VariableDeclaration) visit(ctx.varDecl(1)),
                ctx.R().getText()
        );
    }

    @Override
    public AbstractNode visitIfElse(MicroCParser.IfElseContext ctx) {
        if(ctx.elseStmnt() != null){
            return new IfElseNode(
                    (BooleanExpressionNode) visit(ctx.bexpr()),
                    (BlockNode) visit(ctx.blockStmnt()),
                    (ElseNode) visit(ctx.elseStmnt())
            );
        }
        return new IfElseNode(
                (BooleanExpressionNode) visit(ctx.bexpr()),
                (BlockNode) visit(ctx.blockStmnt())
        );
    }

    @Override
    public AbstractNode visitFalseTerm(MicroCParser.FalseTermContext ctx) {
        return new BooleanValueExpressionNode(false);
    }

    @Override
    public AbstractNode visitBexprOpBbexpr(MicroCParser.BexprOpBbexprContext ctx) {
        return new BooleanOpBBooleanNode(
                (BooleanExpressionNode) visit(ctx.bexpr(0)),
                (BooleanExpressionNode) visit(ctx.bexpr(1)),
                ctx.opb().getText()
        );
    }

    @Override
    public AbstractNode visitTrueTerm(MicroCParser.TrueTermContext ctx) {
        return new BooleanValueExpressionNode(false);
    }

    @Override
    public AbstractNode visitVexprOpRvexpr(MicroCParser.VexprOpRvexprContext ctx) {
        return new BooleanOpRBooleanNode(
                (ExpressionNode) visit(ctx.valueExpr(0)),
                (ExpressionNode) visit(ctx.valueExpr(0)),
                ctx.opr().getText()
        );
    }

    @Override
    public AbstractNode visitNotBexpr(MicroCParser.NotBexprContext ctx) {
        return new NegationBooleanExprNode((BooleanExpressionNode) visit(ctx.bexpr()));
    }

    @Override
    public AbstractNode visitElseStmnt(MicroCParser.ElseStmntContext ctx) {
        return new ElseNode((BlockNode) visit(ctx.blockStmnt()));
    }

    @Override
    public AbstractNode visitLAssign(MicroCParser.LAssignContext ctx) {
        return new LAssignNode(
                (IdentifierExpressionNode) visit(ctx.identifierExpr()),
                (ExpressionNode) visit(ctx.valueExpr())
        );
    }

    @Override
    public AbstractNode visitVarIdentifier(MicroCParser.VarIdentifierContext ctx) {
        return new VariableIdentifierNode(ctx.IDENTIFIER().getText());
    }

    @Override
    public AbstractNode visitArrayIndexId(MicroCParser.ArrayIndexIdContext ctx) {
        if (ctx.INTEGER() != null) {
            return new ArrayIdentifierExpression(
                    ctx.IDENTIFIER().get(0).getText(),
                    Integer.parseInt(ctx.INTEGER().getText()));
        }
        return new ArrayIdentifierExpression(
                ctx.IDENTIFIER().get(0).getText(),
                ctx.IDENTIFIER().get(1).getText());

    }

    @Override
    public AbstractNode visitRecFst(MicroCParser.RecFstContext ctx) {
        return new RecAccessNode(RecAccessEnum.FST, ctx.R().getText());
    }

    @Override
    public AbstractNode visitRecSnd(MicroCParser.RecSndContext ctx) {
        return new RecAccessNode(RecAccessEnum.SND, ctx.R().getText());
    }

    @Override
    public AbstractNode visitRecordAssign(MicroCParser.RecordAssignContext ctx) {
        return super.visitRecordAssign(ctx);
    }

    @Override
    public AbstractNode visitNumber(MicroCParser.NumberContext ctx) {
        return new NumberExpressionNode(Integer.parseInt(ctx.INTEGER().getText()));
    }
}
