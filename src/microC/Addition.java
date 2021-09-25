package microC;

public class Addition {
    Expression left;
    Expression right;

    public Addition(Expression left, Expression right) {
        this.left = right;
        this.right = right;
    }


    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}
