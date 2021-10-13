package microC;

import microC.Declaration.ArrayDeclaration;
import microC.Declaration.Declaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.Statement.*;

public class PrintVisitor implements ASTBaseVisitor<String> {

    @Override
    public String visit(ProgramNode prog) {
        return null;
    }

    @Override
    public String visit(BlockNode bstmnt) {
        return null;
    }

    @Override
    public String visit(RecordDeclaration rd) {
        return null;
    }

    @Override
    public String visit(VariableDeclaration vd) {
        return (vd.getIdentifier() + ": " + vd.getType() + " = " + vd.getInitVal());
    }

    @Override
    public String visit(ArrayDeclaration ad) {
        return null;
    }


    //Expressions

    @Override
    public String visit(VariableIdentifierNode n) {
        return n.getIdentifier();
    }

    @Override
    public String visit(NumberExpressionNode n) {
        return String.valueOf(n.getValue());
    }

    @Override
    public String visit(ArrayIdentifierExpression n) {
        return null;
    }


    @Override
    public String visit(BooleanValueExpressionNode n) {
        return null;
    }

    @Override
    public String visit(NegationBooleanExprNode n) {
        return null;
    }

    @Override
    public String visit(BooleanOpBBooleanNode n) {
        return null;
    }

    @Override
    public String visit(BooleanOpRBooleanNode n) {
        var left = n.getLeft();
        var leftString = left.accept(this);
        var right = n.getRight();
        var rightString = right.accept(this);
        var operator = n.getOperator();

        return leftString + operator + rightString;
    }

    @Override
    public String visit(RecAccessNode n) {
        return null;
    }

    // Statements

    @Override
    public String visit(LAssignNode n) {
        return n.getLeft().accept(this) + " = " + n.getRight().accept(this);
    }

    @Override
    public String visit(IfElseNode n) {
        return null;
    }

    @Override
    public String visit(ElseNode n) {
        return null;
    }

    @Override
    public String visit(WhileDeclaration n) {
        return null;
    }

    @Override
    public String visit(ReadStatement n) {
        return null;
    }

    @Override
    public String visit(WriteStatement n) {
        return null;
    }

}
