package microC.ProgramGraph;

import microC.ASTBaseVisitor;
import microC.Declaration.ArrayDeclaration;
import microC.Declaration.Declaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.ProgramNode;
import microC.Statement.*;

public class ProgramGraphBuilderVisitor implements ASTBaseVisitor<Node> {
    @Override
    public Node visit(ProgramNode prog) {
        return null;
    }

    @Override
    public Node visit(BlockNode bstmnt) {
        return null;
    }

    @Override
    public Node visit(RecordDeclaration rd) {
        return null;
    }

    @Override
    public Node visit(VariableDeclaration vd) {
        return null;
    }

    @Override
    public Node visit(ArrayDeclaration ad) {
        return null;
    }

    @Override
    public Node visit(VariableIdentifierNode n) {
        return null;
    }

    @Override
    public Node visit(NumberExpressionNode n) {
        return null;
    }

    @Override
    public Node visit(ArrayIdentifierExpression n) {
        return null;
    }

    @Override
    public Node visit(BooleanOpBBooleanNode n) {
        return null;
    }

    @Override
    public Node visit(BooleanValueExpressionNode n) {
        return null;
    }

    @Override
    public Node visit(NegationBooleanExprNode n) {
        return null;
    }

    @Override
    public Node visit(RecAccessNode n) {
        return null;
    }

    @Override
    public Node visit(BooleanOpRBooleanNode n) {
        return null;
    }

    @Override
    public Node visit(ElseNode n) {
        return null;
    }

    @Override
    public Node visit(IfElseNode n) {
        return null;
    }

    @Override
    public Node visit(LAssignNode n) {
        return null;
    }

    @Override
    public Node visit(ReadStatement n) {
        return null;
    }

    @Override
    public Node visit(WhileDeclaration n) {
        return null;
    }

    @Override
    public Node visit(WriteStatement n) {
        return null;
    }
}