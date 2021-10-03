package microC.Expressions;

import microC.ASTBaseVisitor;

public class BooleanValueExpressionNode extends BooleanExpressionNode {
    private boolean value;

    public BooleanValueExpressionNode(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }

}
