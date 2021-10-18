package microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution;

import microC.ProgramGraph.ProgramGraphNode;

public class ConstraintTriple {
    private ProgramGraphNode endNode;
    private ProgramGraphNode originNode;
    private String value;

    public ConstraintTriple(String value, ProgramGraphNode originNode, ProgramGraphNode endNode) {
        this.value = value;
        this.originNode = originNode;
        this.endNode = endNode;
    }

    public ConstraintTriple(ProgramGraphNode endNode) {
        this.endNode = endNode;
    }

    public ProgramGraphNode getOriginNode() {
        return originNode;
    }

    public void setOriginNode(ProgramGraphNode originNode) {
        this.originNode = originNode;
    }

    public ProgramGraphNode getEndNode() {
        return endNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        if (originNode != null) {
            return "(" + value + ", " + originNode.toString() + ", " + endNode.toString() + ")";
        }
        return "(" + value + ", ?, " + endNode.toString() + ")";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof ConstraintTriple){
            ConstraintTriple objComp = (ConstraintTriple) obj;

            if (this.getValue().equals(objComp.getValue()) &&
            this.originNode == objComp.getOriginNode() && this.endNode == objComp.getEndNode()){
                return true;
            }
            return false;
        }
        return false;
    }
}
