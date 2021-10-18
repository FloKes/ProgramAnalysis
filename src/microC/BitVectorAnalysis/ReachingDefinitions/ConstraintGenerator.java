package microC.BitVectorAnalysis.ReachingDefinitions;

import MathOp.UniOp;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class ConstraintGenerator {
    private ArrayList<String> constraints;
    private KillGenSetGenerator generator;

    public ConstraintGenerator() {
        this.constraints = new ArrayList<>();
    }

    public ArrayList<String> getConstraints(ProgramGraph programGraph){
        String s = "";
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()) {
            if(programGraphNode.getNumber() == 0){
                s = "RD(" + programGraphNode.toString() + ") " + UniOp.supseteq
                        + " ({x, ?, " + programGraphNode.toString() + "),(" + "{y, ?, " + programGraphNode.toString() + ")}";
                constraints.add(s);
            }
            else {
                for (ProgramGraphEdge edge : programGraphNode.getInGoing()) {
                    s = "RD(" + programGraphNode.toString() + ") " + UniOp.supseteq
                            + " (RD(" + edge.getOriginNode().toString() + ")\\("
                    + edge.getKillGenSetRD().getKillSetRD().toString() + "))"
                    + UniOp.union + edge.getKillGenSetRD().getGenSetRD().toString()
                    ;
                    constraints.add(s);

                }
            }
        }
        return constraints;
    }
}
