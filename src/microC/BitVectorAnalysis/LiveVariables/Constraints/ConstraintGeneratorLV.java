package microC.BitVectorAnalysis.LiveVariables.Constraints;

import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetGeneratorLV;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class ConstraintGeneratorLV {
    private ArrayList<ConstraintLV> constraints;
    private KillGenSetGeneratorLV generator;

    public ConstraintGeneratorLV() {constraints = new ArrayList<>();}

    public ArrayList<ConstraintLV> getConstraints(ProgramGraph programGraph){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()) {
            if(programGraphNode.isFinalNode()) {
                ConstraintLV constraintLV = new ConstraintLV(programGraphNode);
                constraints.add(constraintLV);
                programGraphNode.addConstraintLV(constraintLV);
            }
            else {
                for (ProgramGraphEdge edge : programGraphNode.getOutGoing()) {
                    ConstraintLV constraintLV = new ConstraintLV(programGraphNode, edge.getEndNode());
                    var killed = edge.getKillGenSetLV().getKillSetLV();
                    var generated = edge.getKillGenSetLV().getGenSetLV();
                    if(killed != null){
                        constraintLV.setKilled(killed);
                    }
                    if(generated != null){
                        constraintLV.setGenerated(generated);
                    }
                    constraints.add(constraintLV);
                    programGraphNode.addConstraintLV(constraintLV);
                }
            }
        }
        return constraints;
    }
}
