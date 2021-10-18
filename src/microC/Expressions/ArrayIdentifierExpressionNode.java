package microC.Expressions;

import microC.ASTBaseVisitor;

public class ArrayIdentifierExpressionNode extends IdentifierExpressionNode {
    private Integer index;
    private String indexIdentifier;

    public ArrayIdentifierExpressionNode(String identifier, int index) {
        super(identifier);
        this.index = index;
    }

    public ArrayIdentifierExpressionNode(String identifier, String indexIdentifier) {
        super(identifier);
        this.indexIdentifier = indexIdentifier;
    }

    public ArrayIdentifierExpressionNode(String identifier){
        super(identifier);
    }

    public Integer getIndex() {
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


