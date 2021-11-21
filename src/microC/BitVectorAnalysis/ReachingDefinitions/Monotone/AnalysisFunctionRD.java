package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;
import microC.Statement.LAssignNode;
import microC.Statement.Statement;

public class AnalysisFunctionRD {


    public AnalysisAssignmentRD function(ProgramGraphEdge programGraphEdge, AnalysisAssignmentRD analysisAssignment)
    {
        var newAnalysisAssignment = analysisAssignment;
        var identifier = programGraphEdge.getEdgeInformation().getDefined();
        if (identifier instanceof VariableIdentifierExpressionNode)
        {
            System.out.println("ISIIS");
        }

        return newAnalysisAssignment;
    }
}
