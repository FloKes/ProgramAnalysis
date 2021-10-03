package microC.Statement;

import microC.AbstractNode;

import java.util.ArrayList;
import java.util.List;

public class Statements extends AbstractNode {

    private List<Statement> statements = new ArrayList<>();

    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    public List<Statement> getStatements() {
        return statements;
    }

}
