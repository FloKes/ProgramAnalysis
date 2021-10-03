package microC.Declaration;

import microC.ASTBaseVisitor;

public class RecordDeclaration extends Declaration {

    private VariableDeclaration first, second;
    private String identifier;

    public RecordDeclaration(VariableDeclaration first, VariableDeclaration second, String identifier) {
        this.first = first;
        this.second = second;
        this.identifier = identifier;
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
