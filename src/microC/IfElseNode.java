package microC;

public class IfElseNode extends AbstractNode{
    private BooleanExprNode bexpr;
    private BlockNode block;
    private ElseNode elseNode;

    public IfElseNode(BooleanExprNode bexpr, BlockNode block, ElseNode elseNode) {
        this.bexpr = bexpr;
        this.block = block;
        this.elseNode = elseNode;
    }
    public IfElseNode(BooleanExprNode bexpr, BlockNode block) {
        this.bexpr = bexpr;
        this.block = block;
    }
}
