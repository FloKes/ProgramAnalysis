package microC.Expressions;

public abstract class IdentifierExpressionNode extends ExpressionNode {
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public IdentifierExpressionNode(String identifier) {
        this.identifier = identifier;
    }
}
