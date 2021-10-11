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
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (var d : prog.getDecls()) {
            sb.append("D" + i++ + ": " + d.accept(this) + "\n");
        }
        for (var s : prog.getStatements()) {
            sb.append("S" + i++ + ": " + s.accept(this) + "\n");
        }
        return sb.toString();
    }

    @Override
    public String visit(BlockNode bstmnt) {
        return null;
    }

    @Override
    public String visit(RecordDeclaration rd) {
        return "rd";
    }


    @Override
    public String visit(VariableDeclaration vd) {
        return "vd";
    }

    @Override
    public String visit(ArrayDeclaration ad) {
        return "ad";
    }

    @Override
    public String visit(ArrayIdentifierExpression n) {
        return null;
    }

    @Override
    public String visit(BooleanOpBBooleanNode n) {
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
    public String visit(NumberExpressionNode n) {
        return null;
    }

    @Override
    public String visit(RecAccessNode n) {
        return null;
    }

    @Override
    public String visit(VariableIdentifierNode n) {
        return null;
    }

    @Override
    public String visit(BooleanOpRBooleanNode n) {
        return null;
    }

    @Override
    public String visit(ElseNode n) {
        return null;
    }

    @Override
    public String visit(IfElseNode n) {
        return null;
    }

    @Override
    public String visit(LAssignNode n) {
        return null;
    }

    @Override
    public String visit(ReadStatement n) {
        return null;
    }

    @Override
    public String visit(WhileDeclaration n) {
        return null;
    }

    @Override
    public String visit(WriteStatement n) {
        return null;
    }

}
