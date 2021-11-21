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
        this.analysisSpecification = analysisSpecification;
        this.programGraph = programGraph;
        this.analysisSpecification = analysisSpecification;
        initialize();
       // doLoop();
    }


    public void initialize(){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes())
        {
            if (programGraphNode.isOriginNode())
            {
                var aa = analysisSpecification.getInitialElement();
                aa.setProgramGraphNode(programGraphNode);
                programGraphNode.setAnalysisAssignmentRD(aa);
            }
            else {
                var aa = analysisSpecification.getBottom();
                aa.setProgramGraphNode(programGraphNode);
                programGraphNode.setAnalysisAssignmentRD(aa);
            }
        }
    }

//    public void initialize()
//    {
//        var bottom = analysisSpecification.getBottom(programGraph);
//        HashSet<String> identifiers = new HashSet<>();
//        for (ProgramGraphEdge edge: programGraph.getProgramGraphEdges()){
//            if (edge.getEdgeInformation().getDefined() != null) {
//                identifiers.add(edge.getEdgeInformation().getDefined().toString());
//            }
//            var expression = edge.getEdgeInformation().getEdgeExpression().getVariablesUsed();
//            for (ExpressionNode expressionNode: expression){
//                if (expressionNode instanceof IdentifierExpressionNode){
//                    identifiers.add(((IdentifierExpressionNode) expressionNode).toString());
//                }
//            }
//        }
//
//        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes())
//        {
//            if (programGraphNode.isOriginNode())
//            {
//                var rd = new AnalysisAssignmentRD(programGraphNode, identifiers);
//                for (String identifier: identifiers){
//                    rd.setEdgeSet(identifier, "?", "qs");
//                }
//                programGraphNode.setAnalysisAssignmentRD(rd);
//            }
//            else {
//                programGraphNode.setAnalysisAssignmentRD(new AnalysisAssignmentRD(identifiers));
//            }
//        }
//    }

//    public void doLoop(){
//        for (ProgramGraphEdge programGraphEdge: programGraph.getProgramGraphEdges()){
//            analysisFunction.function(programGraphEdge, programGraphEdge.getOriginNode().getAnalysisAssignmentRD());
//        }
//    }
}
