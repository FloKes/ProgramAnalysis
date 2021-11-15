package microC.AnalysisAlgorithms;

import microC.Declaration.ArrayDeclaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.ProgramGraph.EdgeInformation;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DetectionOfSigns {

    private HashMap<String, HashSet<Character>> initMem;

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
            return this.initMem.get(((IdentifierExpressionNode) n).getIdentifier());
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
                    case "*":
                        set.addAll(mult(c1, c2));
                    case "/":
                        set.addAll(div(c1, c2));
                    case ">":
                        set.addAll(gt(c1, c2));
                    case "<":
                        set.addAll(lt(c1, c2));
                }
            }
        }
        return null;
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

    public HashMap<String, HashSet<Character>> generateConstraints(HashMap<String, HashSet<Character>> initMem, EdgeInformation info) {
        this.initMem = initMem;
        var newMem = initMem;
        var newSet = new HashSet<Character>();
        if (info.getDeclarationNode() != null) {
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
            if (info.getVariableModified() == null) {
                throw new RuntimeException("no bueno");
            }
            //LAssign
            var exprNode = info.getExpressionNode();
            var identifier = info.getVariableModified();
            var set = this.getMemory(exprNode);

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
                if(id1.equals("") && id2.equals("")){
                    return initMem;
                }
                else if(!id1.equals("") && id2.equals("")){
                    newMem.put(id1.split("-")[0], set);
                }
                else if(id1.equals("")){
                    newMem.put(id2.split("-")[0], set);
                }
                else{
                    //id1&2  != null
                    newMem.put(id1.split("-")[0], set);
                }
                newMem.put("x",set);

            }
            if(boolNode instanceof BooleanOpBBooleanNode){}
        }
        return newMem;
    }
    private String getId(ExpressionNode e){
        if(e instanceof IdentifierExpressionNode){
            return ((IdentifierExpressionNode) e).getIdentifier();
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
}
