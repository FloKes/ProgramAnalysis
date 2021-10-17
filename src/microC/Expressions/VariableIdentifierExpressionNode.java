package microC.Expressions;

import microC.ASTBaseVisitor;

public class VariableIdentifierExpressionNode extends IdentifierExpressionNode {


    public VariableIdentifierExpressionNode(String identifier) {
        super(identifier);
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
