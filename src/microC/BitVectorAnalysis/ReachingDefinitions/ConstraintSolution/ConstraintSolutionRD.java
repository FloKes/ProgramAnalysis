package microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class ConstraintSolutionRD {
    private ProgramGraphNode programGraphNode;
    private ArrayList<ConstraintTriple> constraintTriples;

    public ConstraintSolutionRD(ProgramGraphNode programGraphNode) {
        this.programGraphNode = programGraphNode;
        this.constraintTriples = new ArrayList<>();
    }

    public void addTriple(ConstraintTriple triple){
        this.constraintTriples.add(triple);
    }

    public ArrayList<ConstraintTriple> getConstraintTriples() {
        return constraintTriples;
    }

    public ProgramGraphNode getProgramGraphNode() {
        return programGraphNode;
    }
}
