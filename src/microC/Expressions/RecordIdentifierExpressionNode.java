package microC.Expressions;

import microC.ASTBaseVisitor;

public class RecordIdentifierExpressionNode extends IdentifierExpressionNode {
    private String fst;
    private String snd;

    public RecordIdentifierExpressionNode(String identifier) {
        super(identifier);
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
