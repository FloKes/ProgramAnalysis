package microC.Expressions;

import microC.ASTBaseVisitor;

public class BooleanOpRBooleanNode extends BooleanExpressionNode {
    private ExpressionNode left, right;
    private String Operator;

    public BooleanOpRBooleanNode(ExpressionNode left, ExpressionNode right, String operator) {
        this.left = left;
        this.right = right;
        Operator = operator;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
