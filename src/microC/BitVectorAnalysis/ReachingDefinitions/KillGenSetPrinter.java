package microC.BitVectorAnalysis.ReachingDefinitions;

import MathOp.UniOp;
import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class KillGenSetPrinter {
    private ArrayList<String> killGenSets;

    public KillGenSetPrinter() {
        this.killGenSets = new ArrayList<>();
    }

//    public ArrayList<String> getKillGenSets(ArrayList<KillGenSetRD> killGenSets){
//        for (KillGenSetRD killGenSetRD: killGenSets) {
//            String s = "KillRD(" + edge.getOriginNode().toString() +", " + edge.toString() + ", " + edge.getEndNode().toString()
//                    + ") = " + getKillSet(edge);
//            killGenSets.add(s);
//
//            s = "GenRD(" + edge.getOriginNode().toString() +", " + edge.toString() + ", " + edge.getEndNode().toString()
//                    + ") = " + getGenSet(edge);
//            killGenSets.add(s);
//        }
//        return killGenSets;
//    }

    public ArrayList<String> getKillGenSetStrings(ArrayList<KillGenSetRD> killGenSets){
        return null;
    }
    public String printKillSet(KillSetRD killSetRD){
        String s = "{" + killSetRD.getKilled() + "}" + " " + UniOp.multi + " " + "{?, qs, q1, ..., qe} "
                + UniOp.multi + " {qs, q1, ..., qe}";
        return s;
    }

    public String printGenSet(GenSetRD genSetRD){
        String s = "{(" + genSetRD.generated + ", " + genSetRD.originNode + ", " + genSetRD.endNode + ")}";
        return s;
    }
}
