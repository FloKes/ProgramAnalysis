package microC;

import microC.Declaration.ArrayDeclaration;
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

    // Declarations
    @Override
    public String visit(VariableDeclaration vd) {
        return (vd.getType() + " " + vd.getIdentifier() + " := " + vd.getInitVal());
    }

    @Override
    public String visit(RecordDeclaration rd) {
        String s = "";
        s = s + "{" + rd.getFirst().accept(this) + "; " + rd.getSecond().accept(this) +"}" + rd.getIdentifier();
        return s;
    }


    @Override
    public String visit(ArrayDeclaration ad) {
        String s = "";
        s = s + ad.getType() + "[" + ad.getSize() + "] " + ad.getIdentifier();
        return s;
    }


    //Expressions

    @Override
    public String visit(ValueExpressionNode n) {
        String s ="";
        s = s + n.getLeft().accept(this) + " " + n.getOperator() + " " + n.getRight().accept(this);
        return s;
    }

    @Override
    public String visit(VariableIdentifierExpressionNode n) {
        return n.toString();
    }

    @Override
    public String visit(NumberExpressionNode n) {
        return String.valueOf(n.getValue());
    }

    @Override
    public String visit(ArrayIdentifierExpressionNode n) {
        if(n.getIndexIdentifier() == null){
            return n.toString() + "["+ n.getIndex() + "]";
        }
        return n.toString() + "[" + n.getIndexIdentifier() + "]";
    }

    @Override
    public String visit(RecordIdentifierExpressionNode n) {
        if (n.getFst() == null && n.getSnd() == null){
            return n.toString();
        }
        if (n.getFst() != null && n.getSnd() == null){
            return n.toString() + ".fst";
        }
        if (n.getFst() == null && n.getSnd() != null){
            return n.toString() + ".snd";
        }
        return "";
    }

    @Override
    public String visit(RecAccessNode n) {
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

    // Statements

    @Override
    public String visit(LAssignNode n) {
        return n.getLeft().accept(this) + " := " + n.getRight().accept(this);
    }

    @Override
    public String visit(RecordAssignNode n) {
        return n.getIdentifier().accept(this) + " := " + "(" + n.getFst().accept(this)
                + ", " + n.getSnd().accept(this) + ")";
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
        String s = "read ";
        s = s + n.getLexpr().accept(this);
        return s;
    }

    @Override
    public String visit(WriteStatement n) {
        String s = "write ";
        s = s + n.getExpressionNode().accept(this);
        return s;
    }

}
