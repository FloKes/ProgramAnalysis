package microC;

public class WriteStatement extends AbstractNode {

    private RExprNode rexpr;

    public WriteStatement(RExprNode rexpr) {
        this.rexpr = rexpr;
    }
}
