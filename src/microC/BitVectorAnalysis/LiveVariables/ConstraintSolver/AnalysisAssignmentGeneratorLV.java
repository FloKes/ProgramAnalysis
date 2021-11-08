package microC.BitVectorAnalysis.LiveVariables.ConstraintSolver;

import microC.BitVectorAnalysis.LiveVariables.KillGen.GenSetLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillSetLV;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolution;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintTriple;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Collections;

public class AnalysisAssignmentGeneratorLV {
    private ArrayList<ConstraintSolutionLV> constraintSolutions;

    public AnalysisAssignmentGeneratorLV() {
        this.constraintSolutions = new ArrayList<>();
    }

    public ArrayList<ConstraintSolutionLV> solveConstraints(ProgramGraph programGraph){
        initializeSolutions(programGraph);
        solveAlgorithm(programGraph);
        return constraintSolutions;
    }


    public void solveAlgorithm(ProgramGraph programGraph) {
    var programGraphEdges = programGraph.getProgramGraphEdges();
    var reverseProgramGraphEdges = new ArrayList<ProgramGraphEdge>();
    for (ProgramGraphEdge edge: programGraphEdges){
        reverseProgramGraphEdges.add(edge);
    }

    Collections.reverse(reverseProgramGraphEdges);
        for (ProgramGraphEdge programGraphEdge : reverseProgramGraphEdges) {
            if(programGraphEdge.getOriginNode() != null) {
                var constraintSolution = constraintSolutions.get(programGraphEdge.getOriginNode().getNumber());
                var solutionSet = analyzeConstraint(programGraphEdge);
                constraintSolution.setSolutionSet(solutionSet);
            }
        }
    }

    public SolutionSet analyzeConstraint (ProgramGraphEdge edge){
        var originNode = edge.getOriginNode();
        var endNode = edge.getEndNode();

        var nextSolutionSet = constraintSolutions.get(endNode.getNumber()).getSolutionSet();

        var currentSolution = constraintSolutions.get(originNode.getNumber());

        var solutionSet = new SolutionSet();

        // TODO do killgens for write and read statements
        solutionSet.setSolutionSet((ArrayList<String>) nextSolutionSet.getSolutionSet().clone());
        excludeKilled(solutionSet, edge.getKillGenSetLV());

        addGenerated(solutionSet, edge.getKillGenSetLV());

        return solutionSet;
    }



    public void excludeKilled (SolutionSet solutionSet, KillGenSetLV killGenSet){
        if(killGenSet == null || killGenSet.getKillSetLV() == null){
            return;
        }
        solutionSet.getSolutionSet().remove(killGenSet.getKillSetLV().getKilled());
    }

    public void addGenerated (SolutionSet solutionSet, KillGenSetLV killGenSet){
        if(killGenSet == null || killGenSet.getGenSetLV() == null)
        {
            return;
        }
        var generatedDefinition = killGenSet.getGenSetLV().getGenerated();
        // Union genLV(qs, a, qe)
        for (String generated: generatedDefinition) {
            if (!solutionSet.getSolutionSet().contains(generated)) {
                solutionSet.addElement(generated);
            }
        }
    }

    public void initializeSolutions (ProgramGraph programGraph){
        var programGraphNodes = programGraph.getProgramGraphNodes();
        for (ProgramGraphNode node: programGraphNodes){
            var newSolution = new ConstraintSolutionLV(node);
            newSolution.setSolutionSet(new SolutionSet());
            constraintSolutions.add(newSolution);
        }
    }

//    public void sortByIdentifier(ArrayList<ConstraintTriple> triples){
//        triples.sort(new tripleComparator());
//    }
}

