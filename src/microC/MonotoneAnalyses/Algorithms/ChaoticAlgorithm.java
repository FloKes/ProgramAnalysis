package microC.MonotoneAnalyses.Algorithms;

import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;
import java.util.Random;

public class ChaoticAlgorithm {

    private ProgramGraph programGraph;
    private AnalysisSpecification analysisSpecification;
    private int numberOfSteps = 0;

    public ChaoticAlgorithm() {
    }

    public void execute(ProgramGraph programGraph, AnalysisSpecification analysisSpecification){
        this.programGraph = programGraph;
        this.analysisSpecification = analysisSpecification;
        initialize();
        doLoop();
        printSolution();
        System.out.println("Algorithm finished with " + numberOfSteps + " steps.");
        clearCache();
    }


    public void initialize(){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes())
        {
            if (!programGraphNode.isOriginNode())
            {
                var aa = analysisSpecification.getBottom();
                analysisSpecification.setAnalysisAssignment(programGraphNode, aa);;
            }
            else {
                var aa = analysisSpecification.getInitialElement();
                analysisSpecification.setAnalysisAssignment(programGraphNode, aa);;
            }
        }
    }

    public void doLoop(){

        //TODO generalise to cover forward analyses
        int counter = 0;
        Random rnd = new Random();
        HashSet<Integer> usedIndexes = new HashSet<>();
        while (true) {
            counter = 0;
            usedIndexes.clear();
            var numberOfEdges = programGraph.getProgramGraphEdges().size();

            for (int i = 0; i< numberOfEdges; i++){
                numberOfSteps ++;
                var randomIndex = rnd.nextInt(numberOfEdges);
                while (usedIndexes.contains(randomIndex))
                {
                    randomIndex = rnd.nextInt(numberOfEdges);
                }
                usedIndexes.add(randomIndex);
                var programGraphEdge = programGraph.getProgramGraphEdges().get(randomIndex);
                var aqs = analysisSpecification.function(programGraphEdge, analysisSpecification.getAnalysisAssignment(programGraphEdge.getOriginNode()));
                var aqe = analysisSpecification.getAnalysisAssignment(programGraphEdge.getEndNode());

                if (!analysisSpecification.isSubset(aqs, aqe))
                {
                    aqe = analysisSpecification.join(aqe, aqs);
                    analysisSpecification.setAnalysisAssignment(programGraphEdge.getEndNode(), aqe);
                    counter ++;
                }
            }

//            for (ProgramGraphEdge programGraphEdge : programGraph.getProgramGraphEdges()) {
//                var aqs = analysisSpecification.function(programGraphEdge, analysisSpecification.getAnalysisAssignment(programGraphEdge.getOriginNode()));
//                var aqe = analysisSpecification.getAnalysisAssignment(programGraphEdge.getEndNode());
//
//                if (!analysisSpecification.isSubset(aqs, aqe))
//                {
//                    aqe = analysisSpecification.join(aqe, aqs);
//                    analysisSpecification.setAnalysisAssignment(programGraphEdge.getEndNode(), aqe);
//                    counter ++;
//                }
//
//            }
            if (counter == 0)
            {
                break;
            }
        }
    }

    public void clearCache(){
        this.programGraph = null;
        this.analysisSpecification = null;
        numberOfSteps = 0;
    }

    public void printSolution()
    {
        analysisSpecification.printSolution(programGraph);
    }
}
