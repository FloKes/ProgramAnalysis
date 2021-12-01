package microC.MonotoneAnalyses.DangerousVariables;

import microC.Expressions.ExpressionNode;
import microC.Expressions.NumberExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;

public class AnalysisSpecificationDV implements AnalysisSpecification {

    private HashSet<String> identifiers;

    public AnalysisSpecificationDV(ProgramGraph programGraph) {
        identifiers = programGraph.getUsedIdentifiers();
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        var aa = new AnalysisAssignmentDV(identifiers);

        return aa;
    }

    @Override
    public AnalysisAssignment getBottom() {
        return new AnalysisAssignmentDV(new HashSet<>());
    }

    @Override
    public void setAnalysisAssignment(ProgramGraphNode programGraphNode, AnalysisAssignment analysisAssignment) {
        programGraphNode.setAnalysisAssignment(analysisAssignment);
    }

    @Override
    public AnalysisAssignment getAnalysisAssignment(ProgramGraphNode programGraphNode) {
        return programGraphNode.getAnalysisAssignmentDV();
    }

    @Override
    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge, AnalysisAssignment analysisAssignment) {
        var aa = (AnalysisAssignmentDV) analysisAssignment.clone();
        var expressionNodes = programGraphEdge.getEdgeInformation().getEdgeExpression().getObjectsUsed();
        var defined = programGraphEdge.getEdgeInformation().getDefined();
        var declared = programGraphEdge.getEdgeInformation().getDeclared();

        if (declared != null){
            if (declared instanceof VariableIdentifierExpressionNode){
                aa.getIdentifiers().remove(declared.toString());
            }
        }
        else if(defined == null){
            return aa;
        }
        else {
            if (defined instanceof VariableIdentifierExpressionNode) {
                for (ExpressionNode expressionNode : expressionNodes) {
                    if (expressionNode instanceof VariableIdentifierExpressionNode) {
                        var variable = (VariableIdentifierExpressionNode) expressionNode;
                        if (aa.getIdentifiers().contains(variable.toString())) {
                            aa.getIdentifiers().add(defined.toString());
                        } else {
                            aa.getIdentifiers().remove(defined.toString());
                        }
                    }

                    if (expressionNode instanceof NumberExpressionNode) {
                        if (expressionNodes.size() == 1){
                            aa.getIdentifiers().remove(defined.toString());
                        }
                        //TODO error in case when we have x = x - 1, as it will remove x from the dangerous variables
                    }
                }
            }
        }
        return aa;
    }

    @Override
    public boolean isUnder(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var dv1 = (AnalysisAssignmentDV) analysisAssignment1;
        var dv2 = (AnalysisAssignmentDV) analysisAssignment2;
        var identifiers1 = dv1.getIdentifiers();
        var identifiers2 = dv2.getIdentifiers();

        for (String identifier: identifiers1){
            if (!identifiers2.contains(identifier)){
                return false;
            }
        }

        return true;
    }

    @Override
    public AnalysisAssignment join(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var joined = (AnalysisAssignmentDV)analysisAssignment1.clone();
        var clone2 = (AnalysisAssignmentDV)analysisAssignment2.clone();
        for (String identifier: clone2.getIdentifiers()){
            joined.getIdentifiers().add(identifier);
        }
        return joined;
    }

    @Override
    public void printSolution(ProgramGraph programGraph) {
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()){
            System.out.println("DV(" + programGraphNode.toString() + ") = " + programGraphNode.getAnalysisAssignmentDV().toString());
        }
    }

    @Override
    public boolean isForwardAnalysis() {
        return true;
    }
}
