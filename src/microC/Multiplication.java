package microC;

public class Multiplication extends Expression {
    Expression left;
    Expression right;

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}
