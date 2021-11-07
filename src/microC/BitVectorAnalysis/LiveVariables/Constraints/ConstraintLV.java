package microC.BitVectorAnalysis.LiveVariables.Constraints;

import microC.BitVectorAnalysis.LiveVariables.KillGen.GenSetLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillSetLV;
import microC.ProgramGraph.ProgramGraphNode;

public class ConstraintLV {
    private ProgramGraphNode node;
    private ProgramGraphNode endNode;
    private KillSetLV objKilled;
    private GenSetLV objGenerated;

    public ConstraintLV(ProgramGraphNode node) {
        this.node = node;
    }

    public ConstraintLV(ProgramGraphNode node, ProgramGraphNode endNode) {
        this.node = node;
        this.endNode = endNode;
    }

    public KillSetLV getKilled() {
        return objKilled;
    }

    public void setKilled(KillSetLV objKilled) {
        this.objKilled = objKilled;
    }

    public GenSetLV getGenerated() {
        return objGenerated;
    }

    public void setGenerated(GenSetLV objGenerated) {
        this.objGenerated = objGenerated;
    }

    public ProgramGraphNode getNode() {
        return node;
    }

    public ProgramGraphNode getEndNode() {
        return endNode;
    }

    public String getKilledString(){
        if(objKilled == null){
            return "{ }";
        }
        return objKilled.toString();
    }

    public String getGeneratedString() {
        if (objGenerated == null) {
            return "{ }";
        }
        return objGenerated.toString();
    }
}
