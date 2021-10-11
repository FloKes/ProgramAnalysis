package microC.Expressions;

import microC.ASTBaseVisitor;

public class RecAccessNode extends IdentifierExpressionNode {

    private RecAccessEnum accessEnum;

    public RecAccessEnum getAccessEnum() {
        return accessEnum;
    }


    public RecAccessNode(RecAccessEnum accessEnum, String Id) {
        super(Id);
        this.accessEnum = accessEnum;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
