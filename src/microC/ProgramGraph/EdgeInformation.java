package microC.ProgramGraph;

import microC.Expressions.IdentifierExpressionNode;

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
