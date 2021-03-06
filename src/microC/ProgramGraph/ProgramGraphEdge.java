package microC.ProgramGraph;

import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetLV;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetRD;

public class ProgramGraphEdge {
    private String text;
    private EdgeInformation edgeInformation;
    private ProgramGraphNode qs;
    private ProgramGraphNode qe;
    private KillGenSetRD killGenSetRD;
    private KillGenSetLV killGenSetLV;

    public ProgramGraphEdge(String text, EdgeInformation edgeInformation) {
        this.text = text;
        this.edgeInformation = edgeInformation;
        this.killGenSetRD = new KillGenSetRD(this);
        this.killGenSetLV = new KillGenSetLV(this);
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

    public KillGenSetLV getKillGenSetLV() {
        return killGenSetLV;
    }

    public void setKillGenSetRD(KillGenSetRD killGenSetRD) {
        this.killGenSetRD = killGenSetRD;
    }

    @Override
    public String toString(){
        return this.text.toString();
    }

}
