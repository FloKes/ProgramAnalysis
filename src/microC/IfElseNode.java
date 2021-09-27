package microC;

public class IfElseNode extends AbstractNode{
    private Bexpression bexpr;
    private BlockNode block;
    private ElseNode elseNode;

    public IfElseNode(Bexpression bexpr, BlockNode block, ElseNode elseNode) {
        this.bexpr = bexpr;
        this.block = block;
        this.elseNode = elseNode;
    }
    public IfElseNode(Bexpression bexpr, BlockNode block) {
        this.bexpr = bexpr;
        this.block = block;
    }
}
