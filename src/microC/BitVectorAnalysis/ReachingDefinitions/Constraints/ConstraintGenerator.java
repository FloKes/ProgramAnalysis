package microC.BitVectorAnalysis.ReachingDefinitions.Constraints;

import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetGenerator;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class ConstraintGenerator {
    private ArrayList<Constraint> constraints;
    private KillGenSetGenerator generator;

    public ConstraintGenerator() {
        this.constraints = new ArrayList<>();
    }

    public ArrayList<Constraint> getConstraints(ProgramGraph programGraph){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()) {
            if(programGraphNode.getNumber() == 0){
                Constraint constraint = new Constraint(programGraphNode, null);
                constraint.setGenerated(null);
                constraints.add(constraint);
                programGraphNode.addConstraint(constraint);
            }
            else {
                for (ProgramGraphEdge edge : programGraphNode.getInGoing()) {
                    Constraint constraint = new Constraint(programGraphNode, edge.getOriginNode());
                    var killed = edge.getKillGenSetRD().getKillSetRD();
                    var generated = edge.getKillGenSetRD().getGenSetRD();
                    if(killed != null){
                        constraint.setKilled(killed);
                    }
                    if(generated != null){
                        constraint.setGenerated(generated);
                    }
                    constraints.add(constraint);
                    programGraphNode.addConstraint(constraint);
                }
            }
        }
        return constraints;
    }
}
