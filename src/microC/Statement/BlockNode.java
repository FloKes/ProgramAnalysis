package microC.Statement;

import microC.ASTBaseVisitor;
import microC.AbstractNode;
import microC.Declaration.Declaration;
import microC.Declaration.Declarations;
import microC.Visitable;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends AbstractNode implements Visitable {
    private List<Declaration> decls = new ArrayList<>();
    private List<Statement> statements = new ArrayList<>();

    public List<Declaration> getDecls() {
        return decls;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void addDecl(Declarations decls) {
        this.decls.addAll(decls.getDecls());
    }

    public void addStatement(Statements statements) {
        this.statements.addAll(statements.getStatements());
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
