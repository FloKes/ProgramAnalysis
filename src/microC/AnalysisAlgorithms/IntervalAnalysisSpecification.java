package microC.AnalysisAlgorithms;

import microC.Declaration.ArrayDeclaration;
import microC.Declaration.Declaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.BooleanExpressionNode;
import microC.Expressions.BooleanOpRBooleanNode;
import microC.Expressions.ExpressionNode;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashMap;
import java.util.HashSet;

public class IntervalAnalysisSpecification implements AnalysisSpecification {

    private HashMap<String, Interval> initMemory;
    private IntervalSet K;

    public IntervalAnalysisSpecification(HashMap<String, Interval> initMemory, IntervalSet intervalPoints) {
        this.initMemory = initMemory;
        this.K = intervalPoints;
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        var aa = new IntervalAnalysisAssignment(initMemory);
        return aa;
    }

    @Override
    public AnalysisAssignment getBottom() {
        var mem = new HashMap<String, Interval>();
        for (var key : initMemory.keySet()) {
            mem.put(key, new Interval(true));
        }
        return new IntervalAnalysisAssignment(mem);
    }

    @Override
    public boolean isSubset(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var small = ((IntervalAnalysisAssignment) analysisAssignment1).getMemory();
        var big = ((IntervalAnalysisAssignment) analysisAssignment2).getMemory();

        for(var key : small.keySet()){
            if (big == null || big.isEmpty() || !(small.get(key).isIn(big.get(key)))){
                return false;
            }
        }
        return true;
    }

    @Override
    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge, AnalysisAssignment analysisAssignment) {
        var edgeInfo = programGraphEdge.getEdgeInformation();
        this.initMemory = ((IntervalAnalysisAssignment)analysisAssignment.clone()).getMemory();
        var newMem = ((IntervalAnalysisAssignment)analysisAssignment.clone()).getMemory();

        //If its a declaration:
        if(edgeInfo.getDeclarationNode() != null){
            var interval = this.handleDecl(edgeInfo.getDeclarationNode());
            newMem.put(edgeInfo.getDeclarationNode().getIdentifier(), interval);
        }
        //If its a statement:
        else if(edgeInfo.getExpressionNode() != null){
            if (edgeInfo.getDefined() == null) {
                throw new RuntimeException("no bueno");
            }
            var identifier = edgeInfo.getDefined();
            var interval = this.handleStatement(edgeInfo.getExpressionNode());
            newMem.put(identifier.getIdentifier(), interval);
        }
        //If its a boolean expression
        else if(edgeInfo.getBooleanExpressionNode() != null){
            if(edgeInfo.getBooleanExpressionNode() instanceof BooleanOpRBooleanNode){
                var boolNode = (BooleanOpRBooleanNode) edgeInfo.getBooleanExpressionNode();
                var interval = this.handleBoolExpr(boolNode);
                //Default to finding the leftmost variable idk...
                newMem.put("CHANGE THIS", interval);
            }

        }

        return new IntervalAnalysisAssignment(newMem);
    }

    @Override
    public AnalysisAssignment join(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var mem1 = ((IntervalAnalysisAssignment) analysisAssignment1).getMemory();
        var mem2 = ((IntervalAnalysisAssignment) analysisAssignment2).getMemory();
        var goalMem = new HashMap<String, Interval>();
        for(var key : mem1.keySet()){
            var newInt = mem1.get(key).join(mem2.get(key));
            goalMem.put(key, newInt);
        }

        return new IntervalAnalysisAssignment(goalMem);
    }

    @Override
    public void setAnalysisAssignment(ProgramGraphNode programGraphNode, AnalysisAssignment analysisAssignment) {
        programGraphNode.setAnalysisAssignmentInt((IntervalAnalysisAssignment) analysisAssignment);
    }

    @Override
    public AnalysisAssignment getAnalysisAssignment(ProgramGraphNode programGraphNode) {
        return programGraphNode.getAnalysisAssignmentInt();
    }

    @Override
    public void printSolution(ProgramGraph programGraph) {

    }

    @Override
    public boolean isForwardAnalysis() {
        return true;
    }

    private Interval handleDecl(Declaration declNode){
        if (declNode instanceof VariableDeclaration) {
            var vd = ((VariableDeclaration) declNode);
            return this.getVDInterval(vd);

        } else if (declNode instanceof RecordDeclaration) {
            var val = ((RecordDeclaration) declNode);
            var int1 = this.getVDInterval(val.getFirst());
            var int2 = this.getVDInterval(val.getSecond());
            return int1.join(int2);

        } else if (declNode instanceof ArrayDeclaration) {
            //Arrays are declared with nothing in them, but we don't know what intervals could be used...
            return new Interval("-inf", "inf");
        }

        throw new RuntimeException("could not handle decl node");
    }
    private Interval getVDInterval(VariableDeclaration vd){
        //since its an assignment, min and max are equal..
        //need to know the smallest and
        var val = vd.getInitVal();
        var sup = K.sup(val);
        var inf = K.inf(val);
        return new Interval(sup, inf);
    }

    private Interval handleStatement(ExpressionNode exprNode){

        return null;
    }

    private Interval handleBoolExpr(BooleanExpressionNode bNode){return null;}

    private Interval plus (Interval i1, Interval i2){
        return null;
    }
    private Interval minus (Interval i1, Interval i2){
        return null;
    }
    private Interval mult (Interval i1, Interval i2){
        return null;
    }
    private Interval div (Interval i1, Interval i2){
        return null;
    }
    private Interval gt (Interval i1, Interval i2){
        return null;
    }
    private Interval lt (Interval i1, Interval i2){
        return null;
    }
}
