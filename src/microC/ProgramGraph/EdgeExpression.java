package microC.ProgramGraph;

import java.util.ArrayList;

public class EdgeExpression {
    private ArrayList<String> variablesUsed;
    private String expression;

    public EdgeExpression(ArrayList<String> variablesUsed, String expression) {
        this.variablesUsed = variablesUsed;
        this.expression = expression;
    }

    public ArrayList<String> getVariablesUsed() {
        return variablesUsed;
    }

    public void setVariablesUsed(ArrayList<String> variablesUsed) {
        this.variablesUsed = variablesUsed;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
