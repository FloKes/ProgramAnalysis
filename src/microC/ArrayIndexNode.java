package microC;

public class ArrayIndexNode<T> extends AbstractNode{
    private T index;

    public ArrayIndexNode(T index) {
        this.index = index;
    }

    public T getIndex() {
        return index;
    }
}
