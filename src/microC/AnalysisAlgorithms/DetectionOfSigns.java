package microC.AnalysisAlgorithms;

import microC.Declaration.ArrayDeclaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.ProgramGraph.EdgeInformation;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashMap;
import java.util.HashSet;

public class DetectionOfSigns  implements AnalysisSpecification {

    private HashMap<String, HashSet<Character>> initMem;

    public DetectionOfSigns(HashMap<String, HashSet<Character>> initMem){
        this.initMem = cloneMem(initMem);
    }

    private HashSet<Character> getMemory(ExpressionNode n) {
        //Handle each kind of expression
        if (n instanceof NumberExpressionNode) {
            var set = new HashSet<Character>();
            var cast = (NumberExpressionNode) n;
            if (cast.getValue() < 0) {
                set.add('-');
            } else if (cast.getValue() > 0) {
                set.add('+');
            } else {
                set.add('0');
            }
            return set;
        }
        if (n instanceof ValueExpressionNode) {
            var cast = (ValueExpressionNode) n;
            var leftMem = this.getMemory(cast.getLeft());
            var rightMem = this.getMemory(cast.getRight());
            return this.applyOp(leftMem, cast.getOperator(), rightMem);
        }
        if(n instanceof IdentifierExpressionNode){
            return this.initMem.get(((IdentifierExpressionNode) n).toString());
        }
        else return null;

    }

    private HashSet<Character> applyOp(HashSet<Character> leftMem, String operator, HashSet<Character> rightMem) {
        var set = new HashSet<Character>();
        for (var c1 : leftMem) {
            for (var c2 : rightMem) {
                switch (operator) {
                    case "+":
                        set.addAll(plus(c1, c2));
                        break;
                    case "-":
                        set.addAll(minus(c1, c2));
                        break;
                    case "*":
                        set.addAll(mult(c1, c2));
                        break;
                    case "/":
                        set.addAll(div(c1, c2));
                        break;
                    case ">":
                        set.addAll(gt(c1, c2));
                        break;
                    case "<":
                        set.addAll(lt(c1, c2));
                        break;
                }
            }
        }
        return set;
    }


    private HashSet<Character> gt(char s1, char s2) {
        var set = new HashSet<Character>();
        String comb = s1 + ">" + s2;
        switch (comb) {
            case "+>+":
            case "+>-":
            case "+>0":
                set.add('+');
                break;
            case "->-":
                set.add('-');
                break;
            case "0>0":
            case "->+":
            case "->0":
            case "0>+":
                break;
            case "0>-":
                set.add('0');
                break;
        }
        return set;
    }

    private HashSet<Character> lt(char s1, char s2) {
        var set = new HashSet<Character>();
        String comb = s1 + "<" + s2;
        switch (comb) {
            case "+<+":
                set.add('+');
                break;
            case "+<-":
            case "0<-":
            case "+<0":
            case "0<0":
                break;
            case "-<-":
            case "-<0":
            case "-<+":
                set.add('-');
                break;
            case "0<+":
                set.add('0');
                break;
        }
        return set;

    }


    private HashSet<Character> div(char s1, char s2) {
        var set = new HashSet<Character>();
        String comb = s1 + "/" + s2;
        switch (comb) {
            case "+/+":
            case "-/-":
                set.add('+');
                set.add('0');
                break;
            case "+/0":
            case "0/0":
            case "-/0":
                break;
            case "0/+":
            case "0/-":
                set.add('0');
                break;
            case "+/-":
            case "-/+":
                set.add('-');
                set.add('0');
                break;
        }
        return set;
    }

    private HashSet<Character> mult(char s1, char s2) {
        var set = new HashSet<Character>();
        String comb = s1 + "*" + s2;
        switch (comb) {
            case "+*+":
            case "-*-":
                set.add('+');
                break;
            case "+*0":
            case "0*0":
            case "0*-":
            case "-*0":
            case "0*+":
                set.add('0');
                break;
            case "+*-":
            case "-*+":
                set.add('-');
                break;
        }
        return set;
    }

    private HashSet<Character> minus(char s1, char s2) {
        var set = new HashSet<Character>();
        String comb = s1 + "-" + s2;
        switch (comb) {
            case "+-+":
            case "---":
                set.add('+');
                set.add('0');
                set.add('-');
                break;
            case "+-0":
            case "0--":
            case "+--":
                set.add('+');
                break;
            case "0-+":
            case "--0":
            case "--+":
                set.add('-');
                break;
            case "0-0":
                set.add('0');
                break;
        }
        return set;
    }

    private HashSet<Character> plus(char s1, char s2) {
        var set = new HashSet<Character>();
        String comb = s1 + "+" + s2;
        switch (comb) {
            case "+++":
            case "++0":
            case "0++":
                set.add('+');
                break;
            case "++-":
            case "-++":
                set.add('+');
                set.add('-');
                set.add('0');
                break;
            case "-+0":
            case "0+-":
            case "-+-":
                set.add('-');
                break;
            case "0+0":
                set.add('0');
                break;
        }
        return set;
    }

    private HashMap<String, HashSet<Character>> cloneMem(HashMap<String, HashSet<Character>> mem){
        var newMem = new HashMap<String, HashSet<Character>>();
        for (var key: mem.keySet()) {
            var set = new HashSet<>(mem.get(key));
            newMem.put(key, set);
        }
        return newMem;
    }
    public HashMap<String, HashSet<Character>> generateConstraints(HashMap<String, HashSet<Character>> initMem, EdgeInformation info) {
        //Shouldn't need to clone twice but worried about loose references in the code
        this.initMem = cloneMem(initMem);
        var newMem = cloneMem(this.initMem);

        if (info.getDeclarationNode() != null) {
            var newSet = new HashSet<Character>();
            //Declaration
            var declNode = info.getDeclarationNode();
            if (declNode instanceof VariableDeclaration) {
                var val = ((VariableDeclaration) declNode).getInitVal();
                if (val < 0) {
                    newSet.add('-');
                } else if (val == 0) {
                    newSet.add('0');
                } else {
                    newSet.add('+');
                }
                newMem.put(((VariableDeclaration) declNode).getIdentifier(), newSet);

            } else if (declNode instanceof RecordDeclaration) {
            } else if (declNode instanceof ArrayDeclaration) {
            }

        } else if (info.getExpressionNode() != null) {
            if (info.getDefined() == null) {
                throw new RuntimeException("no bueno");
            }
            //LAssign
            var exprNode = info.getExpressionNode();
            var identifier = info.getDefined();
            var set = this.getMemory(exprNode);
            newMem.put(identifier.getIdentifier(), set);

            // var := var op var or var:= expr
        } else if (info.getBooleanExpressionNode() != null) {
            var boolNode = info.getBooleanExpressionNode();
            //case var x > y
            if (boolNode instanceof BooleanOpRBooleanNode) {
                var cast = (BooleanOpRBooleanNode) boolNode;
                HashSet<Character> leftMem = this.getMemory(cast.getLeft()), rightMem = this.getMemory(cast.getRight());
                var set = this.applyOp(leftMem, cast.getOperator(), rightMem);
                var id1 = this.getId(cast.getLeft());
                var id2 = this.getId(cast.getRight());
                String id;
                if(id1.equals("") && id2.equals("")){
                    return initMem;
                }
                else if(!id1.equals("") && id2.equals("")){
                    id = id1.split("-")[0];
                }
                else if(id1.equals("")){
                    id = id2.split("-")[0];
                }
                else{
                    //id1&2  != null
                    id = id1.split("-")[0];
                }
                if(info.isNot()){
                    // set = initMem - set
                    var invertedSet = new HashSet<Character>();
                    for (var c : initMem.get(id)) {
                        if(!set.contains(c)){
                            invertedSet.add(c);
                        }
                    }
                    set = invertedSet;
                }
                newMem.put(id, set);
            }
            if(boolNode instanceof BooleanOpBBooleanNode){
                int a = 0;
            }
        }
        return newMem;
    }
    private String getId(ExpressionNode e){
        if(e instanceof IdentifierExpressionNode){
            return ((IdentifierExpressionNode) e).toString();
        }
        else if(e instanceof ValueExpressionNode){
            var left = this.getId(((ValueExpressionNode) e).getLeft());
            var right = this.getId(((ValueExpressionNode) e).getRight());
            if(left.equals("")){
                return right;
            }
            else return left + "-" + right;
            // "xy"
        }
        // 1
        else if(e instanceof NumberExpressionNode){
            return "";
        }

        return "";
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        var aa = new AnalysisAssignmentDoS(this.cloneMem(this.initMem));
        return aa;
    }

    @Override
    public AnalysisAssignment getBottom() {
        var memory = new HashMap<String, HashSet<Character>>();

        for (var s: this.initMem.keySet()) {
            memory.put(s, new HashSet<>());
        }
        return new AnalysisAssignmentDoS(memory);
    }

    @Override
    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge, AnalysisAssignment analysisAssignment) {
        var aa = (AnalysisAssignmentDoS) analysisAssignment;
        var mem = this.generateConstraints(aa.getMemory(), programGraphEdge.getEdgeInformation());
        return new AnalysisAssignmentDoS(this.cloneMem(mem));
    }

    @Override
    public void setAnalysisAssignment(ProgramGraphNode programGraphNode, AnalysisAssignment analysisAssignment) {
        programGraphNode.setAnalysisAssignmentDoS((AnalysisAssignmentDoS) analysisAssignment);
    }

    @Override
    public AnalysisAssignment getAnalysisAssignment(ProgramGraphNode programGraphNode) {
        return programGraphNode.getAnalysisAssignmentDoS();
    }

    @Override
    public boolean isSubset(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var small = ((AnalysisAssignmentDoS)analysisAssignment1).getMemory();
        var big = ((AnalysisAssignmentDoS)analysisAssignment2).getMemory();

        for(var key : small.keySet()){
            if(big == null || big.isEmpty() || !big.get(key).containsAll(small.get(key))){
                return false;
            }
        }
        return true;

    }

    @Override
    public AnalysisAssignment join(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var newMem = this.cloneMem(((AnalysisAssignmentDoS)analysisAssignment1).getMemory());
        var goalMem = this.cloneMem(((AnalysisAssignmentDoS)analysisAssignment2).getMemory());
        for (var key : newMem.keySet()) {
            goalMem.get(key).addAll(newMem.get(key));
        }
        return new AnalysisAssignmentDoS(goalMem);
    }

    @Override
    public void printSolution(ProgramGraph programGraph) {
        for (var n : programGraph.getProgramGraphNodes()) {
            System.out.println("Node: " + n.toString());
            for (var s : n.getAnalysisAssignmentDoS().getMemory().keySet()) {
                System.out.print(s + ": ");
                for (var k: n.getAnalysisAssignmentDoS().getMemory().get(s)) {
                    System.out.print(k + ",");
                }
                System.out.println("");
            }
        }
    }
}
