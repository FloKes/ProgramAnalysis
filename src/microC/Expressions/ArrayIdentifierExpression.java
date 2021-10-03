package microC.Expressions;

import microC.ASTBaseVisitor;

public class ArrayIdentifierExpression extends IdentifierExpressionNode {
    private int index;
    private String indexIdentifier;
    private String identifier;

    public ArrayIdentifierExpression(String identifier, int index) {
        this.index = index;
        this.identifier = identifier;
    }

    public ArrayIdentifierExpression(String indexIdentifier, String identifier) {
        this.indexIdentifier = indexIdentifier;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
