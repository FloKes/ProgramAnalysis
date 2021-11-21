package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import microC.ProgramGraph.ProgramGraphNode;

public class EdgeSet {
    private String originNode;
    private String endNode;

    public EdgeSet(String originNode, String endNode) {
        this.originNode = originNode;
        this.endNode = endNode;
    }

    public String getOriginNode() {
        return originNode;
    }

    public String getEndNode() {
        return endNode;
    }

    @Override
    public java.lang.String toString(){
        return "(" + originNode + ", " + endNode + ")";
    }
}
