package microC;

import microC.Declaration.ArrayDeclaration;
import microC.Declaration.Declaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.Statement.*;

public interface ASTBaseVisitor<T> {

    //PROGRAM
    T visit(ProgramNode prog);

    //BLOCK
    T visit(BlockNode bstmnt);

    //DECLARATIONS

    T visit(RecordDeclaration rd);

    T visit(VariableDeclaration vd);

    T visit(ArrayDeclaration ad);

    //EXPRESSIONS
    T visit (ValueExpressionNode n);

    T visit (VariableIdentifierNode n);

    T visit (NumberExpressionNode n);

    T visit(ArrayIdentifierExpression n);

    T visit(BooleanValueExpressionNode n);

    T visit(NegationBooleanExprNode n);

    T visit(BooleanOpBBooleanNode n);

    T visit(BooleanOpRBooleanNode n);

    T visit(RecAccessNode n);



    //STATEMENTS

    T visit(LAssignNode n);

    T visit(IfElseNode n);

    T visit(ElseNode n);

    T visit(WhileDeclaration n);

    T visit(ReadStatement n);

    T visit(WriteStatement n);
}
