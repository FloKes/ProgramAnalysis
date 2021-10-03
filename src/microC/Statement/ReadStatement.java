package microC.Statement;

import microC.ASTBaseVisitor;
import microC.Expressions.IdentifierExpressionNode;

public class ReadStatement extends Statement {

    private IdentifierExpressionNode lexpr;

    public ReadStatement(IdentifierExpressionNode lexpr) {
        this.lexpr = lexpr;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
