package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import microC.BitVectorAnalysis.ReachingDefinitions.Monotone.Interfaces.AnalysisAssignment;
import microC.BitVectorAnalysis.ReachingDefinitions.Monotone.Interfaces.AnalysisSpecification;
import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;

public class AnalysisSpecificationRD implements AnalysisSpecification {
    private HashSet<String> identifiers;

    public AnalysisSpecificationRD(ProgramGraph programGraph) {
        identifiers = new HashSet<>();
        for (ProgramGraphEdge edge: programGraph.getProgramGraphEdges()){
            if (edge.getEdgeInformation().getDefined() != null) {
                identifiers.add(edge.getEdgeInformation().getDefined().toString());
            }
            var expression = edge.getEdgeInformation().getEdgeExpression().getVariablesUsed();
            for (ExpressionNode expressionNode: expression){
                if (expressionNode instanceof IdentifierExpressionNode){
                    identifiers.add(((IdentifierExpressionNode) expressionNode).toString());
                }
            }
        }
    }

    @Override
    public AnalysisAssignment getBottom()
    {
        return new AnalysisAssignmentRD(identifiers);
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        var aa = new AnalysisAssignmentRD(identifiers);
        for (String identifier: identifiers){
            aa.setEdgeSet(identifier, "?", "qs");
        }
        return aa;
    }
}
