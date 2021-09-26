package microC;

public class Multiplication extends Rexpression {
    Rexpression left;
    Rexpression right;

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}
