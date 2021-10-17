package microC.Statement;

import microC.ASTBaseVisitor;
import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;
import microC.Expressions.RecAccessNode;
import microC.Expressions.RecordIdentifierExpressionNode;

public class RecordAssignNode extends Statement{
    private RecordIdentifierExpressionNode identifier;
    private ExpressionNode fst;
    private ExpressionNode snd;

    public RecordAssignNode(RecordIdentifierExpressionNode identifier, ExpressionNode fst, ExpressionNode snd) {
        this.identifier = identifier;
        this.fst = fst;
        this.snd = snd;
    }

    public IdentifierExpressionNode getIdentifier() {
        return identifier;
    }

    public ExpressionNode getFst() {
        return fst;
    }

    public ExpressionNode getSnd() {
        return snd;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
