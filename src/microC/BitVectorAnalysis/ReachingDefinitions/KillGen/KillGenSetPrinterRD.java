package microC.BitVectorAnalysis.ReachingDefinitions.KillGen;

import MathOp.UniOp;

import java.util.ArrayList;

public class KillGenSetPrinterRD {
    private ArrayList<String> killGenSets;

    public KillGenSetPrinterRD() {
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
        ArrayList<String> strings = new ArrayList<>();
        for (KillGenSetRD killGenSetRD: killGenSets) {
            String s = killGenSetRD.toString();
            strings.add(s);
        }
        return strings;
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
