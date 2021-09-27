package microC;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractNode {

    private Declaration declNode;
    private Statement statementNode;

    public Declaration getDeclNode() {
        return declNode;
    }

    public void setDeclNode(Declaration declNode) {
        this.declNode = declNode;
    }

    public Statement getStatementNode() {
        return statementNode;
    }

    public void setStatementNode(Statement statementNode) {
        this.statementNode = statementNode;
    }
}
