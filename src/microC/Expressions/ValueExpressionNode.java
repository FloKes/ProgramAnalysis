package microC.Expressions;

import microC.ASTBaseVisitor;

public class ValueExpressionNode extends ExpressionNode{
    private ExpressionNode left, right;
    private String operator;

    public ValueExpressionNode(ExpressionNode left, ExpressionNode right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
