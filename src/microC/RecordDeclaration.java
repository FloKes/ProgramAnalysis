package microC;

public class RecordDeclaration extends AbstractNode{

    private VariableDeclaration first, second;

    public RecordDeclaration(VariableDeclaration first, VariableDeclaration second) {
        this.first = first;
        this.second = second;
    }

    public VariableDeclaration getFirst() {
        return first;
    }

    public VariableDeclaration getSecond() {
        return second;
    }
}
