package microC.Statement;

import microC.ASTBaseVisitor;
import microC.AbstractNode;
import microC.Visitable;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends AbstractNode implements Visitable {
    private List<Statement> statements = new ArrayList<>();

    public List<Statement> getStatements() {
        return statements;
    }

    public void addStatement(Statements statements) {
        this.statements.addAll(statements.getStatements());
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
