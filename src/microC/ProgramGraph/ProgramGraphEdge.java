package microC.ProgramGraph;

public class ProgramGraphEdge {
    String data;
    ProgramGraphNode qs;
    ProgramGraphNode qe;

    public ProgramGraphEdge(String data) {
        this.data = data;
    }

    public void setOrigin(ProgramGraphNode qs){
        this.qs = qs;
    }

    public void setEnd (ProgramGraphNode qe){ this.qe = qe; }

    public ProgramGraphNode getOriginNode(){
        return this.qs;
    }

    public ProgramGraphNode getEndNode(){
        return this.qe;
    }

    @Override
    public String toString(){
        return this.data.toString();
    }

}
