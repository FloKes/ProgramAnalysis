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
    public void setEnd (ProgramGraphNode qe){
        this.qe = qe;
    }
}
