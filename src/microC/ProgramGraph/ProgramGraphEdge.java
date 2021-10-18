package microC.ProgramGraph;

public class ProgramGraphEdge {
    String text;
    EdgeInformation edgeInformation;
    ProgramGraphNode qs;
    ProgramGraphNode qe;

    public ProgramGraphEdge(String text, EdgeInformation edgeInformation) {
        this.text = text;
        this.edgeInformation = edgeInformation;
    }

    public void setOriginNode(ProgramGraphNode qs){
        this.qs = qs;
    }

    public void setEndNode(ProgramGraphNode qe){ this.qe = qe; }

    public ProgramGraphNode getOriginNode(){
        return this.qs;
    }

    public ProgramGraphNode getEndNode(){
        return this.qe;
    }

    public EdgeInformation getEdgeInformation(){
        return edgeInformation;
    }

    @Override
    public String toString(){
        return this.text.toString();
    }

}
