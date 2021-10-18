package microC.BitVectorAnalysis.ReachingDefinitions;

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
}
