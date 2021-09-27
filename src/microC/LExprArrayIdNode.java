package microC;

public class LExprArrayIdNode extends LExprNode{
    private String identifier;
    private ArrayIndexNode arrayIndex;

    public LExprArrayIdNode(String identifier, ArrayIndexNode arrayIndex) {
        this.identifier = identifier;
        this.arrayIndex = arrayIndex;
    }
}
