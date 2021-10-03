package microC;

import microC.Declaration.ArrayDeclaration;
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
    T visit(ArrayIdentifierExpression n);

    T visit(BooleanOpBBooleanNode n);

    T visit(BooleanValueExpressionNode n);

    T visit(NegationBooleanExprNode n);

    T visit(NumberExpressionNode n);

    T visit(RecAccessNode n);

    T visit(VariableIdentifierNode n);

    T visit(BooleanOpRBooleanNode n);

    //STATEMENTS
    T visit(ElseNode n);

    T visit(IfElseNode n);

    T visit(LAssignNode n);

    T visit(ReadStatement n);

    T visit(WhileDeclaration n);

    T visit(WriteStatement n);


}
