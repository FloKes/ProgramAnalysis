package microC.Statement;

import microC.ASTBaseVisitor;
import microC.Expressions.ExpressionNode;

public class WriteStatement extends Statement {

    private ExpressionNode rexpr;

    public WriteStatement(ExpressionNode rexpr) {
        this.rexpr = rexpr;
    }

    public ExpressionNode getExpressionNode() {
        return rexpr;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
