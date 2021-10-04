package microC.Statement;

import microC.ASTBaseVisitor;

public class ElseNode extends Statement {
    private BlockNode block;

    public ElseNode(BlockNode block) {
        this.block = block;
    }

    public BlockNode getBlock() {
        return block;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
