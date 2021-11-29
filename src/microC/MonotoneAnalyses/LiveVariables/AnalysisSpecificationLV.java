package microC.MonotoneAnalyses.LiveVariables;

import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.ExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;

public class AnalysisSpecificationLV implements AnalysisSpecification {

    private HashSet<String> identifiers;

    public AnalysisSpecificationLV(ProgramGraph programGraph) {
        identifiers = programGraph.getUsedIdentifiers();
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        return new AnalysisAssignmentLV(new HashSet<>());
    }

    @Override
    public AnalysisAssignment getBottom() {
        return new AnalysisAssignmentLV(new HashSet<>());
    }

    @Override
    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge, AnalysisAssignment analysisAssignment) {
        var aa = (AnalysisAssignmentLV) analysisAssignment.clone();
        var expressionNodes = programGraphEdge.getEdgeInformation().getEdgeExpression().getObjectsUsed();
        var defined = programGraphEdge.getEdgeInformation().getDefined();
        var declared = programGraphEdge.getEdgeInformation().getDeclared();

        if (defined != null){
            if (defined instanceof VariableIdentifierExpressionNode){
                aa.getIdentifiers().remove(defined.toString());
            }
            if (defined instanceof ArrayIdentifierExpressionNode){
                var array = (ArrayIdentifierExpressionNode) defined;
                var indexExpression = array.getIndexExpressionElements();
                for (ExpressionNode expressionNode: indexExpression){
                    if(expressionNode instanceof VariableIdentifierExpressionNode){
                        aa.getIdentifiers().add(expressionNode.toString());
                    }
                }
                int i = 0;
            }
        }
        for (ExpressionNode expressionNode : expressionNodes) {
            if (expressionNode instanceof VariableIdentifierExpressionNode) {
                var variable = (VariableIdentifierExpressionNode) expressionNode;
                aa.getIdentifiers().add(variable.toString());
            }
            if (expressionNode instanceof ArrayIdentifierExpressionNode) {
                var array = (ArrayIdentifierExpressionNode) expressionNode;
                aa.getIdentifiers().add(array.toString());
            }
        }

        return aa;
    }



    @Override
    public boolean isSubset(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var dv1 = (AnalysisAssignmentLV) analysisAssignment1;
        var dv2 = (AnalysisAssignmentLV) analysisAssignment2;
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
        var joined = (AnalysisAssignmentLV)analysisAssignment1.clone();
        var clone2 = (AnalysisAssignmentLV)analysisAssignment2.clone();
        for (String identifier: clone2.getIdentifiers()){
            joined.getIdentifiers().add(identifier);
        }
        return joined;
    }

    @Override
    public void printSolution(ProgramGraph programGraph) {
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()){
            System.out.println("LV(" + programGraphNode.toString() + ") = " + programGraphNode.getAnalysisAssignmentLV().toString());
        }
    }

    @Override
    public void setAnalysisAssignment(ProgramGraphNode programGraphNode, AnalysisAssignment analysisAssignment) {
        programGraphNode.setAnalysisAssignment(analysisAssignment);
    }

    @Override
    public AnalysisAssignment getAnalysisAssignment(ProgramGraphNode programGraphNode) {
        return programGraphNode.getAnalysisAssignmentLV();
    }

    @Override
    public boolean isForwardAnalysis() {
        return false;
    }
}
