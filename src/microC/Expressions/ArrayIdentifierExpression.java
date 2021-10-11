package microC.Expressions;

import microC.ASTBaseVisitor;

public class ArrayIdentifierExpression extends IdentifierExpressionNode {
    private int index;
    private String indexIdentifier;

    public ArrayIdentifierExpression(String identifier, int index) {
        super(identifier);
        this.index = index;
    }

    public ArrayIdentifierExpression(String indexIdentifier, String identifier) {
        super(identifier);
        this.indexIdentifier = indexIdentifier;
    }

    public int getIndex() {
        return index;
    }

    public String getIndexIdentifier() {
        return indexIdentifier;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}


