package microC.BitVectorAnalysis.LiveVariables.ConstraintSolver;

import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintTriple;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Collections;

public class ConstraintSolutionLV {
    private ProgramGraphNode programGraphNode;
    private SolutionSet solutionSet;

    public ConstraintSolutionLV(ProgramGraphNode programGraphNode) {
        this.programGraphNode = programGraphNode;
    }

    public SolutionSet getSolutionSet() {
        return solutionSet;
    }

    public void setSolutionSet(SolutionSet solutionSet) {
        this.solutionSet = solutionSet;
    }

    public void sortSolutionSet(){
        Collections.sort(solutionSet.getSolutionSet());
    }

    public ProgramGraphNode getProgramGraphNode() {
        return programGraphNode;
    }
}
