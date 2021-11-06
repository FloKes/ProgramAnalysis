package microC.ProgramGraph;

import microC.Expressions.ExpressionNode;

import java.util.ArrayList;

public class EdgeExpression {
    private ArrayList<ExpressionNode> variablesUsed;
    private String expression;

    public EdgeExpression(ArrayList<ExpressionNode> variablesUsed, String expression) {
        this.variablesUsed = variablesUsed;
        this.expression = expression;
    }

    public ArrayList<ExpressionNode> getVariablesUsed() {
        return variablesUsed;
    }

    public void setVariablesUsed(ArrayList<ExpressionNode> variablesUsed) {
        this.variablesUsed = variablesUsed;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
