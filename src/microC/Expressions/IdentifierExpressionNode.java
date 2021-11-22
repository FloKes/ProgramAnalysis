package microC.Expressions;

public abstract class IdentifierExpressionNode extends ExpressionNode {
    private String identifier;

    @Override
    public String toString() {
        return identifier;
    }

    public IdentifierExpressionNode(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
