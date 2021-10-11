package microC.Statement;

import microC.ASTBaseVisitor;
import microC.Expressions.BooleanExpressionNode;

public class IfElseNode extends Statement {
    private BooleanExpressionNode bexpr;
    private BlockNode block;
    private ElseNode elseNode;

    public IfElseNode(BooleanExpressionNode bexpr, BlockNode block, ElseNode elseNode) {
        this.bexpr = bexpr;
        this.block = block;
        this.elseNode = elseNode;
    }

    public IfElseNode(BooleanExpressionNode bexpr, BlockNode block) {
        this.bexpr = bexpr;
        this.block = block;
    }

    public BooleanExpressionNode getBexpr() {
        return bexpr;
    }

    public BlockNode getBlock() {
        return block;
    }

    public ElseNode getElseNode() {
        return elseNode;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
