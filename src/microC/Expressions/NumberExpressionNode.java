package microC.Expressions;

import microC.ASTBaseVisitor;

public class NumberExpressionNode extends ExpressionNode {
    private int value;

    public NumberExpressionNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
