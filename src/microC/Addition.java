package microC;

public class Addition {
    Rexpression left;
    Rexpression right;

    public Addition(Rexpression left, Rexpression right) {
        this.left = right;
        this.right = right;
    }


    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}
