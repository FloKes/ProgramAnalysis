package microC.BitVectorAnalysis.ReachingDefinitions;


import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class Constraint {
    private ProgramGraphNode node;
    private ProgramGraphNode originNode;
    private KillSetRD objKilled;
    private GenSetRD objGenerated;

    public Constraint(ProgramGraphNode node, ProgramGraphNode originNode) {
        this.node = node;
        this.originNode = originNode;
    }

    public KillSetRD getKilled() {
        return objKilled;
    }

    public void setKilled(KillSetRD objKilled) {
        this.objKilled = objKilled;
    }

    public GenSetRD getGenerated() {
        return objGenerated;
    }

    public void setGenerated (GenSetRD objGenerated){
        this.objGenerated = objGenerated;
    }

    public ProgramGraphNode getNode() {
        return node;
    }

    public ProgramGraphNode getOriginNode() {
        return originNode;
    }

    public String getKilledString(){
        if(objKilled == null){
            return "{ }";
        }
        return objKilled.toString();
    }

    public String getGeneratedString(){
        if(objGenerated == null){
            return "{ }";
        }
        return objGenerated.toString();
    }
}
