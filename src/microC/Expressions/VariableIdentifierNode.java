package microC.Expressions;

import microC.ASTBaseVisitor;

public class VariableIdentifierNode extends IdentifierExpressionNode {


    public VariableIdentifierNode(String identifier) {
        super(identifier);
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
