package microC.BitVectorAnalysis.LiveVariables.KillGen;

import java.util.ArrayList;

public class KillGenSetPrinterLV {
    public ArrayList<String> getKillGenSetStrings(ArrayList<KillGenSetLV> killGenSets){
        ArrayList<String> strings = new ArrayList<>();
        for (KillGenSetLV killGenSetLV: killGenSets) {
            String s = killGenSetLV.toString();
            strings.add(s);
        }
        return strings;
    }
    public String printKillSet(KillSetLV killSetLV){
        String s = "{" + killSetLV.getKilled() + "}";
        return s;
    }

    public String printGenSet(GenSetLV genSetLV){
        String s = "{";
        for (int i = 0; i < genSetLV.getGenerated().size(); i++){
            if(i<genSetLV.getGenerated().size() - 1){
                s += genSetLV.getGenerated().get(i) + ", ";
            }
            else {
                s += genSetLV.getGenerated().get(i);
            }
        }
        s += "}";
        return s;
    }
}
