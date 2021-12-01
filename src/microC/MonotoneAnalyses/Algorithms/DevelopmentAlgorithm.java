package microC.MonotoneAnalyses.Algorithms;

import microC.MonotoneAnalyses.Algorithms.Worklists.Worklist;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

public class DevelopmentAlgorithm {

    private ProgramGraph programGraph;
    private AnalysisSpecification analysisSpecification;
    private Worklist worklist;
    private int numberOfSteps = 0;

    public DevelopmentAlgorithm() {
    }

    public void execute(ProgramGraph programGraph, AnalysisSpecification analysisSpecification, Worklist worklistSpec){
        this.programGraph = programGraph;
        this.analysisSpecification = analysisSpecification;
        //this.worklist = new ArrayList<>();
        this.worklist = worklistSpec;
        initialize();
        doLoop();
        printSolution();
        System.out.println("Algorithm finished with " + numberOfSteps + " steps.");
        clearCache();
    }

    public void initialize(){
        worklist.empty();
        if (analysisSpecification.isForwardAnalysis()) {
            for (ProgramGraphNode programGraphNode : programGraph.getProgramGraphNodes()) {
                if (!programGraphNode.isOriginNode()) {
                    var aa = analysisSpecification.getBottom();
                    analysisSpecification.setAnalysisAssignment(programGraphNode, aa);
                    ;
                    worklist.insert(programGraphNode);
                } else {
                    var aa = analysisSpecification.getInitialElement();
                    analysisSpecification.setAnalysisAssignment(programGraphNode, aa);
                    ;
                    worklist.insert(programGraphNode);
                }
            }
        }
        else {
            for (ProgramGraphNode programGraphNode : programGraph.getProgramGraphNodes()) {
                if (!programGraphNode.isFinalNode()) {
                    var aa = analysisSpecification.getBottom();
                    analysisSpecification.setAnalysisAssignment(programGraphNode, aa);
                    ;
                    worklist.insert(programGraphNode);
                } else {
                    var aa = analysisSpecification.getInitialElement();
                    analysisSpecification.setAnalysisAssignment(programGraphNode, aa);
                    ;
                    worklist.insert(programGraphNode);
                }
            }
        }
    }

    public void doLoop(){
        if (analysisSpecification.isForwardAnalysis()) {
            while (!worklist.isEmpty()){
                var node = worklist.extract();
                if (node.isFinalNode()){
                    numberOfSteps ++;
                    continue;
                }
                for (ProgramGraphEdge programGraphEdge: node.getOutGoing()){
                    numberOfSteps ++;
                    var aqs = analysisSpecification.function(programGraphEdge, analysisSpecification.getAnalysisAssignment(programGraphEdge.getOriginNode()));
                    var aqe = analysisSpecification.getAnalysisAssignment(programGraphEdge.getEndNode());

                    if (!analysisSpecification.isUnder(aqs, aqe))
                    {
                        aqe = analysisSpecification.join(aqe, aqs);
                        analysisSpecification.setAnalysisAssignment(programGraphEdge.getEndNode(), aqe);
                        worklist.insert(programGraphEdge.getEndNode());
                    }
                }
            }
        }
        else {
            while (!worklist.isEmpty()) {
                var node = worklist.extract();
                if (node.isOriginNode()) {
                    numberOfSteps++;
                    continue;
                }
                for (ProgramGraphEdge programGraphEdge : node.getInGoing()) {
                    numberOfSteps++;
                    var aqe = analysisSpecification.function(programGraphEdge, analysisSpecification.getAnalysisAssignment(programGraphEdge.getEndNode()));
                    var aqs = analysisSpecification.getAnalysisAssignment(programGraphEdge.getOriginNode());

                    if (!analysisSpecification.isUnder(aqe, aqs)) {
                        aqs = analysisSpecification.join(aqs, aqe);
                        analysisSpecification.setAnalysisAssignment(programGraphEdge.getOriginNode(), aqs);
                        worklist.insert(programGraphEdge.getOriginNode());
                    }
                }
            }
        }
    }

    public void printSolution(){
        analysisSpecification.printSolution(programGraph);
    }

    public void clearCache(){
        this.programGraph = null;
        this.analysisSpecification = null;
        this.worklist = null;
        numberOfSteps = 0;
    }
}
