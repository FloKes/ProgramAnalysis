package microC;

public class Variable extends Rexpression {
    String id;

    public Variable(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
