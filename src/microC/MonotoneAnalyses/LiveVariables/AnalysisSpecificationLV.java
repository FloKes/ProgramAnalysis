package microC.MonotoneAnalyses.LiveVariables;

import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.ExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;
import java.util.TreeSet;

public class AnalysisSpecificationLV implements AnalysisSpecification {

    private TreeSet<String> identifiers;

    public AnalysisSpecificationLV(ProgramGraph programGraph) {
        identifiers = new TreeSet<>();
        identifiers.addAll(programGraph.getUsedIdentifiers());
        identifiers.addAll(programGraph.getUsedIndexIdentifiers());
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        return new AnalysisAssignmentLV(new TreeSet<>());
    }

    @Override
    public AnalysisAssignment getBottom() {
        return new AnalysisAssignmentLV(new TreeSet<>());
    }

    @Override
    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge, AnalysisAssignment analysisAssignment) {
        var aa = (AnalysisAssignmentLV) analysisAssignment.clone();
        var objectsUsed = programGraphEdge.getEdgeInformation().getEdgeExpression().getObjectsUsed();
        var arrayIndexObjectsUsed = programGraphEdge.getEdgeInformation().getEdgeExpression().getArrayIndexObjectsUsed();
        var recordObjectsUsed = programGraphEdge.getEdgeInformation().getEdgeExpression().getArrayIndexObjectsUsed();
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
            }
            if (defined instanceof RecordIdentifierExpressionNode){
                var record = (RecordIdentifierExpressionNode) defined;
                if (declared instanceof RecordIdentifierExpressionNode){
                    aa.getIdentifiers().remove(record.getIdentifier() + ".fst");
                    aa.getIdentifiers().remove(record.getIdentifier() + ".snd");
                }
                if (record.getFst() == null && record.getSnd() == null){
                    aa.getIdentifiers().remove(record.getIdentifier() + ".fst");
                    aa.getIdentifiers().remove(record.getIdentifier() + ".snd");
                }
                if(record.getFst() != null && record.getSnd() == null){
                    aa.getIdentifiers().remove(record.getIdentifier() + ".fst");
                }
                else if(record.getSnd() != null && record.getFst() == null){
                    aa.getIdentifiers().remove(record.getIdentifier() + ".snd");
                }
                else if(record.getSnd() != null && record.getFst() != null){
                    aa.getIdentifiers().remove(record.getIdentifier() + ".fst");
                    aa.getIdentifiers().remove(record.getIdentifier() + ".snd");
                }
            }
        }

        //Expression Objects used
        for (ExpressionNode expressionNode : objectsUsed) {
            if (expressionNode instanceof VariableIdentifierExpressionNode) {
                var variable = (VariableIdentifierExpressionNode) expressionNode;
                aa.getIdentifiers().add(variable.toString());
            }
            if (expressionNode instanceof ArrayIdentifierExpressionNode){
                var array = (ArrayIdentifierExpressionNode) expressionNode;
                var indexExpression = array.getIndexExpressionElements();
                for (ExpressionNode arrayExpressionNode: indexExpression){
                    if(arrayExpressionNode instanceof VariableIdentifierExpressionNode){
                        aa.getIdentifiers().add(arrayExpressionNode.toString());
                    }
                }
                int i = 0;
            }
            if (expressionNode instanceof RecordIdentifierExpressionNode){
                var record = (RecordIdentifierExpressionNode) expressionNode;

                if(record.getFst() != null && record.getSnd() == null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".fst");
                }
                else if(record.getSnd() != null && record.getFst() == null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".snd");
                }
                else if(record.getSnd() != null && record.getFst() != null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".fst");
                    aa.getIdentifiers().add(record.getIdentifier() + ".snd");
                }
            }
        }

        //Array index objects
        for (ExpressionNode expressionNode : arrayIndexObjectsUsed) {
            if (expressionNode instanceof VariableIdentifierExpressionNode) {
                var variable = (VariableIdentifierExpressionNode) expressionNode;
                aa.getIdentifiers().add(variable.toString());
            }
            if (expressionNode instanceof ArrayIdentifierExpressionNode){
                var array = (ArrayIdentifierExpressionNode) expressionNode;
                var indexExpression = array.getIndexExpressionElements();
                for (ExpressionNode arrayExpressionNode: indexExpression){
                    if(arrayExpressionNode instanceof VariableIdentifierExpressionNode){
                        aa.getIdentifiers().add(arrayExpressionNode.toString());
                    }
                }
                int i = 0;
            }
            if (expressionNode instanceof RecordIdentifierExpressionNode){
                var record = (RecordIdentifierExpressionNode) expressionNode;
                if(record.getFst() != null && record.getSnd() == null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".fst");
                }
                else if(record.getSnd() != null && record.getFst() == null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".snd");
                }
                else if(record.getSnd() != null && record.getFst() != null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".fst");
                    aa.getIdentifiers().add(record.getIdentifier() + ".snd");
                }
            }
        }

        // Record index objects
        for (ExpressionNode expressionNode : recordObjectsUsed) {
            if (expressionNode instanceof VariableIdentifierExpressionNode) {
                var variable = (VariableIdentifierExpressionNode) expressionNode;
                aa.getIdentifiers().add(variable.toString());
            }
            if (expressionNode instanceof ArrayIdentifierExpressionNode){
                var array = (ArrayIdentifierExpressionNode) expressionNode;
                var indexExpression = array.getIndexExpressionElements();
                for (ExpressionNode arrayExpressionNode: indexExpression){
                    if(arrayExpressionNode instanceof VariableIdentifierExpressionNode){
                        aa.getIdentifiers().add(arrayExpressionNode.toString());
                    }
                }
                int i = 0;
            }
            if (expressionNode instanceof RecordIdentifierExpressionNode){
                var record = (RecordIdentifierExpressionNode) expressionNode;
                if(record.getFst() != null && record.getSnd() == null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".fst");
                }
                else if(record.getSnd() != null && record.getFst() == null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".snd");
                }
                else if(record.getSnd() != null && record.getFst() != null){
                    aa.getIdentifiers().add(record.getIdentifier() + ".fst");
                    aa.getIdentifiers().add(record.getIdentifier() + ".snd");
                }
            }
        }

        return aa;
    }


    @Override
    public boolean isUnder(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
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
