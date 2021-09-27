package microC;

public class WriteStatement extends AbstractNode {

    private Rexpression rexpr;

    public WriteStatement(Rexpression rexpr) {
        this.rexpr = rexpr;
    }
}
