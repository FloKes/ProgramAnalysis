package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import microC.BitVectorAnalysis.ReachingDefinitions.Monotone.Interfaces.AnalysisSpecification;
import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;

public class ChaoticAlgorithm {

    private ProgramGraph programGraph;
    private AnalysisSpecification analysisSpecification;

    public ChaoticAlgorithm() {
    }

    public void execute(ProgramGraph programGraph, AnalysisSpecification analysisSpecification){
        this.programGraph = programGraph;
        this.analysisSpecification = analysisSpecification;
        initialize();
        doLoop();
        printSolution();
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
        int counter = 0;
        while (true) {
            counter = 0;
            for (ProgramGraphEdge programGraphEdge : programGraph.getProgramGraphEdges()) {
                var aqs = analysisSpecification.function(programGraphEdge, analysisSpecification.getAnalysisAssignment(programGraphEdge.getOriginNode()));
                var aqe = analysisSpecification.getAnalysisAssignment(programGraphEdge.getEndNode());

                if (!analysisSpecification.isSubset(aqs, aqe))
                {
                    aqe = analysisSpecification.join(aqe, aqs);
                    analysisSpecification.setAnalysisAssignment(programGraphEdge.getEndNode(), aqe);
                    counter ++;
                }

            }
            if (counter == 0)
            {
                break;
            }
        }
    }

    public void printSolution()
    {
        analysisSpecification.printSolution(programGraph);
    }
}
