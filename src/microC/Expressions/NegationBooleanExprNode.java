package microC.Expressions;

import microC.ASTBaseVisitor;

public class NegationBooleanExprNode extends BooleanExpressionNode {
    private BooleanExpressionNode expression;

    public NegationBooleanExprNode(BooleanExpressionNode expression) {
        this.expression = expression;
    }

    public BooleanExpressionNode getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }

}
