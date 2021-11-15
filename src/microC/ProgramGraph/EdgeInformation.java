package microC.ProgramGraph;

import microC.Declaration.Declaration;
import microC.Expressions.BooleanExpressionNode;
import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;


public class EdgeInformation {
    private IdentifierExpressionNode variableModified;
    private BooleanExpressionNode booleanExpressionNode;
    private boolean isNot = false;
    private Declaration declarationNode;
    private ExpressionNode expressionNode;
    private EdgeExpression edgeExpression;

    public boolean isNot() {
        return isNot;
    }

    public void setNot(boolean not) {
        isNot = not;
    }

    public Declaration getDeclarationNode() {
        return declarationNode;
    }

    public void setDeclarationNode(Declaration declarationNode) {
        this.declarationNode = declarationNode;
    }

    public BooleanExpressionNode getBooleanExpressionNode() {
        return booleanExpressionNode;
    }

    public void setBooleanExpressionNode(BooleanExpressionNode booleanExpressionNode) {
        this.booleanExpressionNode = booleanExpressionNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public void setExpressionNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

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
