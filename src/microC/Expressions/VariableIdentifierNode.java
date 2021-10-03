package microC.Expressions;

import microC.ASTBaseVisitor;

public class VariableIdentifierNode extends IdentifierExpressionNode {

    private String id;

    public VariableIdentifierNode(String text) {
        this.id = text;
    }

    public String getId() {
        return id;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
