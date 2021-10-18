package microC.ProgramGraph;

import microC.BitVectorAnalysis.ReachingDefinitions.KillGenSetRD;

public class ProgramGraphEdge {
    private String text;
    private EdgeInformation edgeInformation;
    private ProgramGraphNode qs;
    private ProgramGraphNode qe;
    private KillGenSetRD killGenSetRD;

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

    public KillGenSetRD getKillGenSetRD() {
        return killGenSetRD;
    }

    public void setKillGenSetRD(KillGenSetRD killGenSetRD) {
        this.killGenSetRD = killGenSetRD;
    }

    @Override
    public String toString(){
        return this.text.toString();
    }

}
