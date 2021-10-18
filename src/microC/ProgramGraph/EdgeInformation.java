package microC.ProgramGraph;

import microC.Expressions.IdentifierExpressionNode;
import microC.PrintVisitor;

import java.util.ArrayList;

public class EdgeInformation {
    private IdentifierExpressionNode variableModified;
    private EdgeExpression edgeExpression;

    public IdentifierExpressionNode getVariableModified() {
        return variableModified;
    }

    public void setVariableModified(IdentifierExpressionNode variableModified) {
        this.variableModified = variableModified;
    }

    public EdgeExpression getEdgeExpression() {
        return edgeExpression;
    }

    public void setEdgeExpression(EdgeExpression edgeExpression) {
        this.edgeExpression = edgeExpression;
    }
}
