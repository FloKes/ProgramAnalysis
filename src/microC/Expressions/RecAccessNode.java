package microC.Expressions;

import microC.ASTBaseVisitor;

public class RecAccessNode extends IdentifierExpressionNode {

    private RecAccessEnum accessEnum;
    private String Id;

    public RecAccessEnum getAccessEnum() {
        return accessEnum;
    }

    public String getId() {
        return Id;
    }

    public RecAccessNode(RecAccessEnum accessEnum, String Id) {
        this.accessEnum = accessEnum;
        this.Id = Id;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
