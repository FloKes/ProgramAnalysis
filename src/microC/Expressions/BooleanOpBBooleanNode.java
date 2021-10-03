package microC.Expressions;

import microC.ASTBaseVisitor;

public class BooleanOpBBooleanNode extends BooleanExpressionNode {
    private BooleanExpressionNode left, right;
    private String operator;

    public BooleanOpBBooleanNode(BooleanExpressionNode left, BooleanExpressionNode right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
