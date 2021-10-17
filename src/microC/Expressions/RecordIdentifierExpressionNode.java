package microC.Expressions;

import microC.ASTBaseVisitor;

public class RecordIdentifierExpressionNode extends IdentifierExpressionNode {


    public RecordIdentifierExpressionNode(String identifier) {
        super(identifier);
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
