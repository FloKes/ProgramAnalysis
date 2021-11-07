package microC.BitVectorAnalysis.ReachingDefinitions.KillGen;

import microC.ProgramGraph.ProgramGraphEdge;

public class KillGenSetRD {
    private KillSetRD killSetRD;
    private GenSetRD genSetRD;
    private ProgramGraphEdge programGraphEdge;

    public KillGenSetRD(ProgramGraphEdge programGraphEdge) {
        this.programGraphEdge = programGraphEdge;
    }

    public KillGenSetRD(KillSetRD killSetRD, GenSetRD genSetRD, ProgramGraphEdge programGraphEdge){
        this.killSetRD = killSetRD;
        this.genSetRD = genSetRD;
        this.programGraphEdge = programGraphEdge;
    }

    public KillSetRD getKillSetRD() {
        return killSetRD;
    }

    public void setKillSetRD(KillSetRD killSetRD) {
        this.killSetRD = killSetRD;
    }

    public GenSetRD getGenSetRD() {
        return genSetRD;
    }

    public void setGenSetRD(GenSetRD genSetRD) {
        this.genSetRD = genSetRD;
    }

    public ProgramGraphEdge getProgramGraphEdge(){
        return programGraphEdge;
    }

    @Override
    public String toString(){
        String srd = "KillRD(" + programGraphEdge.getOriginNode().toString() +", " + programGraphEdge.toString() + ", " + programGraphEdge.getEndNode().toString() +") = ";
        srd += killSetRD.toString() + "\n";
        srd += "GenRD(" + programGraphEdge.getOriginNode().toString() +", " + programGraphEdge.toString() + ", " + programGraphEdge.getEndNode().toString() +") = ";
        srd += genSetRD.toString() + "\n";
        return srd;
    }
}
