package microC.ProgramGraph;

public class BooleanExpressionEdgeInfo extends EdgeInformation {
    private String type = "Boolean";
    private String label = "boolean expr";

    public BooleanExpressionEdgeInfo(){

    }
    public BooleanExpressionEdgeInfo getNegated(){
        var ei = new BooleanExpressionEdgeInfo();
        ei.setLabel("!(" + this.label + ")");
        return ei;
    }
    public String getType(){
        return this.type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
