package microC.AnalysisAlgorithms;

import microC.Declaration.ArrayDeclaration;
import microC.Declaration.Declaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Arrays;
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
        return new IntervalAnalysisAssignment(initMemory);
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
    public boolean isUnder(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var small = ((IntervalAnalysisAssignment) analysisAssignment1).getMemory();
        var big = ((IntervalAnalysisAssignment) analysisAssignment2).getMemory();

        for(var key : small.keySet()){
            try{
            if (big == null || big.isEmpty() || !(small.get(key).isIn(big.get(key)))){
                return false;
            }}
            catch (NullPointerException e){
                int a = 0;
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
                var interval = this.handleBoolExpr(boolNode, edgeInfo.isNot());
                //Default to finding the leftmost variable idk...
                newMem.put(getId(boolNode.getLeft()), interval);
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
        for (var n : programGraph.getProgramGraphNodes()) {
            System.out.print(n.toString() +" = ");
            var mem = n.getAnalysisAssignmentInt().getMemory();
            for (var s : mem.keySet()) {
                System.out.print(s + " -> [" + mem.get(s).getMin() + "," + mem.get(s).getMax() + "] ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public boolean isForwardAnalysis() {
        return true;
    }

    private Interval handleDecl(Declaration declNode){
        if (declNode instanceof VariableDeclaration) {
            var vd = ((VariableDeclaration) declNode);
            return this.getVDInterval(vd.getInitVal());

        } else if (declNode instanceof RecordDeclaration) {
            var val = ((RecordDeclaration) declNode);
            var int1 = this.getVDInterval(val.getFirst().getInitVal());
            var int2 = this.getVDInterval(val.getSecond().getInitVal());
            return int1.join(int2);

        } else if (declNode instanceof ArrayDeclaration) {
            //Arrays are declared with nothing in them, but we don't know what intervals could be used...
            return new Interval("-inf", "inf");
        }

        throw new RuntimeException("could not handle decl node");
    }
    private Interval getVDInterval(int val){
        //since its an assignment, min and max are equal..
        //need to know the sup and inf tho though.
        var sup = K.sup(val);
        var inf = K.inf(val);
        return new Interval(sup, inf);
    }

    private Interval handleStatement(ExpressionNode exprNode){
        return computeInterval(exprNode);
    }

    private Interval computeInterval(ExpressionNode n){
        if(n instanceof NumberExpressionNode){
            var val = ((NumberExpressionNode) n).getValue();
            return new Interval(K.sup(val), K.inf(val));
        }
        if(n instanceof ValueExpressionNode){
            var cast = (ValueExpressionNode) n;
            var leftInterval = this.computeInterval(cast.getLeft());
            var rightInterval = this.computeInterval(cast.getRight());
            return this.applyOp(leftInterval, cast.getOperator(), rightInterval);
        }
        if(n instanceof IdentifierExpressionNode){
            return this.initMemory.get(((IdentifierExpressionNode) n).getIdentifier());
        }
        return null;
    }

    private Interval applyOp(Interval left, String op, Interval right){
        switch (op){
            case "+":
                return plus(left, right);
            case "-":
                return minus(left, right);
            case "*":
                return mult(left, right);
            case "/":
                return div(left, right);
        }
        throw new RuntimeException("Unsupported operator: " + op);
    }
    private Interval plus (Interval i1, Interval i2){
        if(i1.isBottom() || i2.isBottom()){
            return new Interval(true);
        }
        String min, max;
        //calc
        if(i1.isMinInf() || i2.isMinInf()){
            if(i1.isMaxInf() || i2.isMaxInf()){
                //both inf
                return new Interval("-inf", "inf");
            }
            //min inf, max possibly value
            var maxResult = Integer.parseInt(i1.getMax()) + Integer.parseInt(i2.getMax());
            return new Interval("-inf", K.inf(maxResult));
        }
        //min possibly value
        var minResult = Integer.parseInt(i1.getMin()) + Integer.parseInt(i2.getMin());
        min = K.sup(minResult);
        if(i1.isMaxInf() || i2.isMaxInf()) {
            return new Interval(min, "inf");
        }
        var maxResult = Integer.parseInt(i1.getMax()) + Integer.parseInt(i2.getMax());
        max = K.inf(maxResult);
        return new Interval(min, max);
    }
    private Interval minus (Interval i1, Interval i2){
        if(i1.isBottom() || i2.isBottom()){
            return new Interval(true);
        }

        String min, max;

        if(!i1.isMinInf()){
            //k1min not -inf
            if(!i2.isMaxInf()){
                min = K.sup(Integer.parseInt(i1.getMin()) - Integer.parseInt(i2.getMax()));
            }
            else{
                // min = k1min - inf
                min = "-inf";
            }
        }else{
            // min = -inf
            min = "-inf";
        }
        if(!i1.isMaxInf()){
            if(!i2.isMinInf()){
                // max = k1max - k2min
                max = K.inf(Integer.parseInt(i1.getMax()) - Integer.parseInt(i2.getMin()));
            }else{
                // max = k1max - -inf
                max = "inf";
            }
        }else{
            // max = inf
            max = "inf";
        }

        return new Interval(min, max);
    }
    private Interval mult (Interval i1, Interval i2){
        if(i1.isBottom() || i2.isBottom()){
            return new Interval(true);
        }
        String min, max;
        //calc
        if(i1.isMinInf() || i2.isMinInf()){
            if(i1.isMaxInf() || i2.isMaxInf()){
                //both inf
                return new Interval("-inf", "inf");
            }

            max = multMax(i1.getMin(), i2.getMin(),i1.getMax(), i2.getMax());

            return max.equals("inf")
                    ? new Interval("-inf", "inf")
                    : new Interval("-inf", K.inf(Integer.parseInt(max)));
        }
        //min possibly value
        min = multMin(i1.getMin(), i2.getMin(),i1.getMax(), i2.getMax());
        if(min.equals("inf")){
            int a = 0;
        }
        if(!min.equals("-inf")){
            min = K.sup(Integer.parseInt(min));
        }
        //max not inf
        if(!(i1.isMaxInf() || i2.isMaxInf())) {
            max = multMax(i1.getMin(), i2.getMin(),i1.getMax(), i2.getMax());
            max = K.inf(Integer.parseInt(max));
        }else{
            max = "inf";
        }

        return new Interval(min,max);
    }
    private String multMin(String min1, String min2, String max1, String max2){
        var r1 = stringMult(min1,min2);
        var r2 = stringMult(min1,max2);
        var r3 = stringMult(max1,min2);
        var r4 = stringMult(max1,max2);
        var list = Arrays.asList(r1,r2,r3,r4);
        String min = null;
        for(var r : list){
            if(r.equals("inf"))continue;
            if(r.equals("-inf")){
                return "-inf";
            }
            var rInt = Integer.parseInt(r);
            if(min == null || Integer.parseInt(min) > rInt){
                min = r;
            }
        }
        return min;
    }
    private String multMax(String min1, String min2, String max1, String max2){
        //min = -inf & max != inf
        //min = !=-inf & max != inf
        var r1 = stringMult(min1,min2);
        var r2 = stringMult(min1,max2);
        var r3 = stringMult(max1,min2);
        var r4 = stringMult(max1,max2);
        var list = Arrays.asList(r1,r2,r3,r4);
        String max = null;
        for(var r : list){
            if(r.equals("-inf"))continue;
            if(r.equals("inf")){
                return "inf";
            }
            var rInt = Integer.parseInt(r);
            if(max == null || Integer.parseInt(max) < rInt){
                max = r;
            }
        }
        return max;
    }
    private String stringMult(String s1, String s2){
        var s1NegInf = s1.equals("-inf");
        var s1Inf = s1.equals("inf");
        var s2NegInf = s2.equals("-inf");
        var s2Inf = s2.equals("inf");
        //Both -Inf or Inf
        if((s1NegInf && s2NegInf) || (s1Inf && s2Inf)){
            return "inf";
        }
        //One -Inf and other Inf
        if((s1Inf && s2NegInf) || (s1NegInf && s2Inf)){
            return "-inf";
        }
        //One -Inf and other val
        if(s1NegInf){
            //s2 MUST be a value if we go here, since both cant be -inf
            var s2int = Integer.parseInt(s2);
            if(s2int > 0){
                return "-inf";
            }else if(s2int == 0){
                return "0";
            }
            else{
                return "inf";
            }
        }
        if(s2NegInf){
            //s1 MUST be a value if we go here, since both cant be -inf
            var s1int = Integer.parseInt(s1);
            if(s1int > 0){
                return "-inf";
            }else if(s1int == 0){
                return "0";
            }
            else{
                return "inf";
            }
        }
        //One Inf and other val
        if(s1Inf){
            //s2 MUST be a value if we go here, since both cant be -inf
            var s2int = Integer.parseInt(s2);
            if(s2int > 0){
                return "inf";
            }else if(s2int == 0){
                return "0";
            }
            else{
                return "-inf";
            }
        }

        if(s2Inf){
            //s1 MUST be a value if we go here, since both cant be -inf
            var s1int = Integer.parseInt(s1);
            if(s1int > 0){
                return "inf";
            }else if(s1int == 0){
                return "0";
            }
            else{
                return "-inf";
            }
        }

        //Both Val
        var s1int = Integer.parseInt(s1);
        var s2int = Integer.parseInt(s2);
        return String.valueOf(s1int*s2int);
    }
    private Interval div (Interval i1, Interval i2){
        throw new RuntimeException("Division not yet supported..");
    }
    //i1 < i2
    private String lt (Interval i1, Interval i2){
        if(i1.isBottom() || i2.isBottom()){
            return "";
        }
        //Compare values
        if(!i1.isMaxInf() && !i2.isMinInf()){
            var k2 = Integer.parseInt(i2.getMin());
            var k1 = Integer.parseInt(i1.getMax());
            if(k1 < k2){
                return "tt";
            }
        }
        if(!i1.isMinInf() && !i2.isMaxInf()){
            var k2 = Integer.parseInt(i2.getMax());
            var k1 = Integer.parseInt(i1.getMin());
            if(k1 >= k2){
                return "ff";
            }
        }
        return "ttff";
    }

    //i1 > i2
    private String gt (Interval i1, Interval i2){
        if(i1.isBottom() || i2.isBottom()){
            return "";
        }
        //Compare values
        if(!i1.isMaxInf() && !i2.isMinInf()){
            var k2 = Integer.parseInt(i2.getMin());
            var k1 = Integer.parseInt(i1.getMax());
            if(k1 < k2){
                return "ff";
            }
        }
        //i1.min >= i2.max
        if(!i1.isMinInf() && !i2.isMaxInf()){
            var k2 = Integer.parseInt(i2.getMax());
            var k1 = Integer.parseInt(i1.getMin());
            if(k1 >= k2){
                return "tt";
            }
        }
        return "ttff";
    }
    private Interval handleBoolExpr(BooleanOpRBooleanNode bNode, boolean isNegated){
        //1. Find leftmost variable identifier
        var id = this.getId(bNode.getLeft());
        //2. Find its interval from memory
        var mem = this.initMemory.get(id);
        //3. Generate the Base(K) set
        var base = this.K.base();
        //4. Keep all that are "in" the variable memory
        var inList = new ArrayList<Interval>();
        for(var i : base){
            if(i.isIn(mem)){
                inList.add(i);
            }
        }
        //5. Remove all (including normal) that do not return tt on the condition
        var rightInt = this.computeInterval(bNode.getRight());
        var trueList = new ArrayList<Interval>();
        inList.add(mem);
        for (var i: inList){
            if(bNode.getOperator().equals(">")){
                var res = gt(i, rightInt);
                if(isNegated && res.equals("ff")){
                    trueList.add(i);
                }else if(!isNegated && res.equals("tt")){
                    trueList.add(i);

                //I have no clue how to deal with ttff
                // Sometimes it should be applied, other times it shouldn't...
                }else if(isNegated && res.equals("ttff")){
                    trueList.add(i);
                }

            }
            else if(bNode.getOperator().equals("<")){
                var res = lt(i, rightInt);
                if(isNegated && res.equals("ff")){
                    trueList.add(i);
                }else if(res.equals("tt")){
                    trueList.add(i);
                }
            }
        }
        //6. Join the remaining sets and return
        Interval result = null;
        for(var i : trueList){
            if(result == null){
                result = i;
            }
            else{
                result = result.join(i);
            }
        }
        return result;
    }

    private String getId(ExpressionNode e){
        if(e instanceof IdentifierExpressionNode){
            return ((IdentifierExpressionNode) e).getIdentifier();
        }
        else if(e instanceof ValueExpressionNode){
            return this.getId(((ValueExpressionNode) e).getLeft());
        }
        throw new RuntimeException("Tried to find leftmost Id but found nothing..");
    }


}
