package microC.MonotoneAnalyses.Algorithms;

import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.Stack;

public class LIFOWorklistAlgorithm{
    private ProgramGraph programGraph;
    private AnalysisSpecification analysisSpecification;
    private Stack<ProgramGraphNode> worklist;
    private int numberOfSteps = 0;

    public LIFOWorklistAlgorithm() {
    }

    public void execute(ProgramGraph programGraph, AnalysisSpecification analysisSpecification){
        this.programGraph = programGraph;
        this.analysisSpecification = analysisSpecification;
        this.worklist = new Stack<>();
        initialize();
        doLoop();
        printSolution();
        System.out.println("Algorithm finished with " + numberOfSteps + " steps.");
    }

    public void initialize(){
        empty();
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes())
        {
            if (!programGraphNode.isOriginNode())
            {
                var aa = analysisSpecification.getBottom();
                analysisSpecification.setAnalysisAssignment(programGraphNode, aa);;
                insert(programGraphNode);
            }
            else {
                var aa = analysisSpecification.getInitialElement();
                analysisSpecification.setAnalysisAssignment(programGraphNode, aa);;
                insert(programGraphNode);
            }
        }
    }

    public void doLoop(){
        while (!worklist.isEmpty()){
            var node = extract(worklist);
            for (ProgramGraphEdge programGraphEdge: node.getOutGoing()){
                numberOfSteps ++;
                var aqs = analysisSpecification.function(programGraphEdge, analysisSpecification.getAnalysisAssignment(programGraphEdge.getOriginNode()));
                var aqe = analysisSpecification.getAnalysisAssignment(programGraphEdge.getEndNode());

                if (!analysisSpecification.isUnder(aqs, aqe))
                {
                    aqe = analysisSpecification.join(aqe, aqs);
                    analysisSpecification.setAnalysisAssignment(programGraphEdge.getEndNode(), aqe);
                    insert(programGraphEdge.getEndNode());
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

    public Stack<ProgramGraphNode> empty() {
        worklist.clear();
        return worklist;
    }


    public Stack<ProgramGraphNode> insert(ProgramGraphNode programGraphNode) {
        worklist.push(programGraphNode);
        return worklist;
    }


    public ProgramGraphNode extract(Stack<ProgramGraphNode> worklist) {
        var node = worklist.pop();
        return node;
    }
}
