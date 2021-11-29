package microC.Declaration;

import microC.ASTBaseVisitor;

public class RecordDeclaration extends Declaration {

    private VariableDeclaration first, second;

    public RecordDeclaration(VariableDeclaration first, VariableDeclaration second, String identifier) {
        super(identifier);
        this.first = first;
        this.second = second;
    }

    public VariableDeclaration getFirst() {
        return first;
    }

    public VariableDeclaration getSecond() {
        return second;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
