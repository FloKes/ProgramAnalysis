package microC.ProgramGraph;

import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;
import microC.Expressions.NumberExpressionNode;

import java.util.ArrayList;

public class EdgeExpression {
    private ArrayList<ExpressionNode> objectsUsed;
    private ArrayList<ExpressionNode> arrayIndexObjectsUsed;
    private ArrayList<ExpressionNode> recordObjectsUsed;
    private String expression;

    public EdgeExpression() {
        objectsUsed = new ArrayList<>();
        arrayIndexObjectsUsed = new ArrayList<>();
    }

    public EdgeExpression(ArrayList<ExpressionNode> objectsUsed, String expression) {
        this.objectsUsed = objectsUsed;
        this.expression = expression;
        arrayIndexObjectsUsed = new ArrayList<>();
    }

    public void setArrayIndexObjectsUsed(ArrayList<ExpressionNode> arrayIndexObjectsUsed)
    {
        this.arrayIndexObjectsUsed = arrayIndexObjectsUsed;
    }

    public ArrayList<ExpressionNode> getArrayIndexObjectsUsed() {
        return arrayIndexObjectsUsed;
    }

    public ArrayList<ExpressionNode> getRecordObjectsUsed() {
        return recordObjectsUsed;
    }

    public void setRecordObjectsUsed(ArrayList<ExpressionNode> recordObjectsUsed) {
        this.recordObjectsUsed = recordObjectsUsed;
    }

    public ArrayList<ExpressionNode> getObjectsUsed() {
        return objectsUsed;
    }

    public void setObjectsUsed(ArrayList<ExpressionNode> objectsUsed) {
        this.objectsUsed = objectsUsed;
    }

    public ArrayList<ExpressionNode> getVariablesUsed(){
        ArrayList<ExpressionNode> newList = new ArrayList<>();
        for (ExpressionNode object: objectsUsed){
            if (!(object instanceof NumberExpressionNode)){
                newList.add(object);
            }
        }
        return newList;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
