package microC;

public class Number extends Rexpression {

    int num;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}
