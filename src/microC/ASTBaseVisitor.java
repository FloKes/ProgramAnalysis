package microC;

public class ASTBaseVisitor<T> {

    public T visit(AbstractNode an) {
        return visitChildren(an);
    }

    public T visitChildren(AbstractNode node) {
        T result = defaultResult();
        for (AbstractNode n : node.getChildren()) {
            T newResult = n.accept(this);
            result = aggregateResult(result, newResult);
        }
        return result;
    }

    protected T defaultResult(){
        return null;
    }

    public T visit(Bexpression bexpr) {
        return visitChildren(bexpr);
    }

    public T visit(BlockStatement bstmnt) {
        return visitChildren(bstmnt);
    }

    public T visit(Declaration d) {
        return visitChildren(d);
    }

    public T visit(Lexpression lexpr) {
        return visitChildren(lexpr);
    }

    public T visit(Rexpression rexpr) {
        return visitChildren(rexpr);
    }

    public T visit(Program prog) {
        return visitChildren(prog);
    }

    public T visit(ReadStatement read) {
        return visitChildren(read);
    }

    public T visit(RecordDeclaration rd) {
        return visitChildren(rd);
    }

    public T visit(Statement st) {
        return visitChildren(st);
    }

    public T visit(VariableDeclaration vd) {
        return visitChildren(vd);
    }

    public T visit(WhileDeclaration wd) {
        return visitChildren(wd);
    }

    public T visit(WriteStatement ws) {
        return visitChildren(ws);
    }
}
