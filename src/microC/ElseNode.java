package microC;

public class ElseNode extends AbstractNode {
    private BlockNode block;

    public ElseNode(BlockNode block) {
        this.block = block;
    }
}
