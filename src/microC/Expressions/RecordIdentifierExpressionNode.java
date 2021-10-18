package microC.Expressions;

import microC.ASTBaseVisitor;

public class RecordIdentifierExpressionNode extends IdentifierExpressionNode {
    private RecAccessEnum fst;
    private RecAccessEnum snd;

    public RecordIdentifierExpressionNode(String identifier) {
        super(identifier);
    }

    public RecordIdentifierExpressionNode(String identifier, RecAccessEnum recEnum) {
        super(identifier);
        if(recEnum == RecAccessEnum.FST){
            this.fst = recEnum;
        }
        if(recEnum == RecAccessEnum.SND){
            this.snd = recEnum;
        }
    }

    public RecordIdentifierExpressionNode(String identifier, RecAccessEnum fst, RecAccessEnum snd) {
        super(identifier);
        this.fst = fst;
        this.snd = snd;
    }

    public RecAccessEnum getFst() {
        return fst;
    }

    public RecAccessEnum getSnd() {
        return snd;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
