package microC.BitVectorAnalysis.ReachingDefinitions.Constraints;

import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetGeneratorRD;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class ConstraintGeneratorRD {
    private ArrayList<ConstraintRD> constraints;
    private KillGenSetGeneratorRD generator;

    public ConstraintGeneratorRD() {
        this.constraints = new ArrayList<>();
    }

    public ArrayList<ConstraintRD> getConstraints(ProgramGraph programGraph){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()) {
            if(programGraphNode.getNumber() == 0){
                ConstraintRD constraintRD = new ConstraintRD(programGraphNode, null);
                constraintRD.setGenerated(null);
                constraints.add(constraintRD);
                programGraphNode.addConstraintRD(constraintRD);
            }
            else {
                for (ProgramGraphEdge edge : programGraphNode.getInGoing()) {
                    ConstraintRD constraintRD = new ConstraintRD(programGraphNode, edge.getOriginNode());
                    var killed = edge.getKillGenSetRD().getKillSetRD();
                    var generated = edge.getKillGenSetRD().getGenSetRD();
                    if(killed != null){
                        constraintRD.setKilled(killed);
                    }
                    if(generated != null){
                        constraintRD.setGenerated(generated);
                    }
                    constraints.add(constraintRD);
                    programGraphNode.addConstraintRD(constraintRD);
                }
            }
        }
        return constraints;
    }
}
