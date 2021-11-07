package microC.BitVectorAnalysis.LiveVariables;

import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetGeneratorLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetPrinterLV;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetRD;
import microC.ProgramGraph.ProgramGraph;

import java.util.ArrayList;

public class LiveVariablesAnalysis {
    private KillGenSetGeneratorLV killGenSetGenerator;
    private KillGenSetPrinterLV killGenSetPrinter;

    public LiveVariablesAnalysis() {
        killGenSetGenerator = new KillGenSetGeneratorLV();
        killGenSetPrinter = new KillGenSetPrinterLV();
    }

    public ArrayList<KillGenSetLV> getKillGenSets(ProgramGraph programGraph){
        var killGenSets = killGenSetGenerator.getKillGenSets(programGraph);
        return killGenSets;
    }

    public ArrayList<String> getKillGenSetsStrings(ArrayList<KillGenSetLV> killGenSets){
        return killGenSetPrinter.getKillGenSetStrings(killGenSets);
    }
}
