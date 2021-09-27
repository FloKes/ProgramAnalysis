package microC;

public class LAssignNode extends AbstractNode{

    private LExprNode left;
    private RExprNode right;

    public LAssignNode(LExprNode left, RExprNode right) {
        this.left = left;
        this.right = right;
    }
}
