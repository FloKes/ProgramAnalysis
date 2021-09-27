package microC;

public class ReadStatement extends AbstractNode {

    private Lexpression lexpr;

    public ReadStatement(Lexpression lexpr) {
        this.lexpr = lexpr;
    }
}
