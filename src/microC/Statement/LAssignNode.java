package microC.Statement;

import microC.ASTBaseVisitor;
import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;

public class LAssignNode extends Statement {

    private IdentifierExpressionNode left;
    private ExpressionNode right;

    public LAssignNode(IdentifierExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
