package microC;

public class ReadStatement extends AbstractNode {

    private LExprNode lexpr;

    public ReadStatement(LExprNode lexpr) {
        this.lexpr = lexpr;
    }
}
