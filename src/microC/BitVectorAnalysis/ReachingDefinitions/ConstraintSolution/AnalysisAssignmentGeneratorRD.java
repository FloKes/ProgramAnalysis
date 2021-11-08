package microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution;

import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.GenSetRD;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillSetRD;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;

import java.util.ArrayList;

public class AnalysisAssignmentGeneratorRD {
    //private ArrayList<Constraint> constraints;
    private ArrayList<ConstraintSolution> constraintSolutions;

    public AnalysisAssignmentGeneratorRD() {
        this.constraintSolutions = new ArrayList<>();
    }

    public ArrayList<ConstraintSolution> solveConstraints(ProgramGraph programGraph){
        initializeSolutions(programGraph);
        solveAlgorithm2(programGraph);
        return constraintSolutions;
    }


    public void solveAlgorithm2(ProgramGraph programGraph){
        var programGraphEdges = programGraph.getProgramGraphEdges();
        int notSubsetCounter;
        while (true) {
            notSubsetCounter = 0;
            for (ProgramGraphEdge programGraphEdge : programGraphEdges) {
                analyzeConstraint(programGraphEdge);
                if (!isSubset(analyzeConstraint(programGraphEdge)
                        , constraintSolutions.get(programGraphEdge.getEndNode().getNumber()))) {

                    addTriplesToSolution(analyzeConstraint(programGraphEdge)
                            , constraintSolutions.get(programGraphEdge.getEndNode().getNumber()));
                    notSubsetCounter++;
                }
            }
            if(notSubsetCounter == 0){
                break;
            }
        }
    }

    public ArrayList<ConstraintTriple> analyzeConstraint (ProgramGraphEdge edge){
        var originNode = edge.getOriginNode();
        var endNode = edge.getEndNode();

        var previousSolutionTriples = constraintSolutions.get(originNode.getNumber()).getConstraintTriples();

        var currentSolution = constraintSolutions.get(endNode.getNumber());

        ArrayList<ConstraintTriple> triplesToAdd = new ArrayList<>();

        if(edge.getKillGenSetRD().getKillSetRD() != null){
            triplesToAdd.addAll(excludeKilled(previousSolutionTriples, edge.getKillGenSetRD().getKillSetRD()));
        }
        else {
            triplesToAdd.addAll(previousSolutionTriples);
        }

        if(edge.getKillGenSetRD().getGenSetRD() != null){
            addGenerated(triplesToAdd, edge.getKillGenSetRD().getGenSetRD());
        }

        return triplesToAdd;
    }

    public void addTriplesToSolution(ArrayList<ConstraintTriple> triples, ConstraintSolution solution){
        var currentSolutionTriples = solution.getConstraintTriples();
        for (ConstraintTriple triple: triples){
            if(!currentSolutionTriples.contains(triple)){
                currentSolutionTriples.add(triple);
            }
        }
        sortByIdentifier(solution.getConstraintTriples());
    }

    public boolean isSubset(ArrayList<ConstraintTriple> triples, ConstraintSolution solution){
        for (ConstraintTriple triple: triples){
            if(!solution.getConstraintTriples().contains(triple)){
                return false;
            }
        }
        return true;
    }

    public void copyPreviousTriples(ArrayList<ConstraintTriple> previousTriples, ArrayList<ConstraintTriple> triples){
        triples.addAll(previousTriples);
    }

    public ArrayList<ConstraintTriple> excludeKilled (ArrayList<ConstraintTriple> previousTriples, KillSetRD killSet){
        ArrayList<ConstraintTriple> triples = new ArrayList<>();
        for(ConstraintTriple previousTriple: previousTriples){
            var previousDefinition = previousTriple.getValue();
            var killedDefinition = killSet.getKilled();

            if (!previousDefinition.equals(killedDefinition)) {
                triples.add(previousTriple);
            }
        }
        return triples;
    }

    public void addGenerated (ArrayList<ConstraintTriple> triples, GenSetRD genSet){
            var generatedDefinition = genSet.getGenerated();
            var triple = new ConstraintTriple(generatedDefinition, genSet.originNode, genSet.endNode);
            // Union genRD(qs, a, qe)
            if(!triples.contains(triple)){
                triples.add(triple);
            }
    }


    public void initializeSolutions (ProgramGraph programGraph){
        var programGraphNodes = programGraph.getProgramGraphNodes();
        var initialNode = programGraphNodes.get(0);
        var initialNodeSolution = new ConstraintSolution(initialNode);
        for (String declaration: programGraph.getDeclaredObjects()){
            var intialTriple = new ConstraintTriple(initialNode);
            intialTriple.setOriginNode(null);
            intialTriple.setValue(declaration);
            initialNodeSolution.addTriple(intialTriple);
        }
        sortByIdentifier(initialNodeSolution.getConstraintTriples());
        constraintSolutions.add(initialNodeSolution);

        for (int i = 1; i < programGraphNodes.size(); i++){
            constraintSolutions.add(new ConstraintSolution(programGraphNodes.get(i)));
        }
    }

    public void sortByIdentifier(ArrayList<ConstraintTriple> triples){
        triples.sort(new tripleComparator());
    }
}
