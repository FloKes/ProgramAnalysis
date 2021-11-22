package microC.MonotoneAnalyses.Algorithms;

import com.kitfox.svg.A;
import microC.MonotoneAnalyses.Algorithms.Worklists.Worklist;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ChaoticWorklistAlgorithm{
    private ProgramGraph programGraph;
    private AnalysisSpecification analysisSpecification;
    private ArrayList<ProgramGraphNode> worklist;
    private int numberOfSteps = 0;

    public ChaoticWorklistAlgorithm() {
    }

    public void execute(ProgramGraph programGraph, AnalysisSpecification analysisSpecification){
        this.programGraph = programGraph;
        this.analysisSpecification = analysisSpecification;
        this.worklist = new ArrayList<>();
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

                if (!analysisSpecification.isSubset(aqs, aqe))
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

    public ArrayList<ProgramGraphNode> empty(){
        worklist.clear();
        return worklist;
    }

    public ArrayList<ProgramGraphNode> insert(ProgramGraphNode programGraphNode){
        worklist.add(programGraphNode);
        return worklist;
    }

    public ProgramGraphNode extract (ArrayList<ProgramGraphNode> worklist){
        Random random = new Random();
        var node = worklist.remove(random.nextInt(worklist.size()));
        return node;
    }
}
