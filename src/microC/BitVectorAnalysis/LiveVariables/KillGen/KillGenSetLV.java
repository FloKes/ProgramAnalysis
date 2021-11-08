package microC.BitVectorAnalysis.LiveVariables.KillGen;

import microC.ProgramGraph.ProgramGraphEdge;

public class KillGenSetLV {
    private KillSetLV killSetLV;
    private GenSetLV genSetLV;
    private ProgramGraphEdge programGraphEdge;

    public KillGenSetLV(ProgramGraphEdge programGraphEdge) {
        this.programGraphEdge = programGraphEdge;
    }

    public KillGenSetLV(KillSetLV killSetLV, GenSetLV genSetLV, ProgramGraphEdge programGraphEdge){
        this.killSetLV = killSetLV;
        this.genSetLV = genSetLV;
        this.programGraphEdge = programGraphEdge;
    }

    public KillSetLV getKillSetLV() {
        return killSetLV;
    }
    public void setKillSetLV(KillSetLV killSetLV) {
        this.killSetLV = killSetLV;
    }

    public GenSetLV getGenSetLV() {
        return genSetLV;
    }
    public void setGenSetLV(GenSetLV genSetLV) {
        this.genSetLV = genSetLV;
    }

    public ProgramGraphEdge getProgramGraphEdge(){
        return programGraphEdge;
    }

    @Override
    public String toString(){
        String slv = "KillLV(" + programGraphEdge.getOriginNode().toString() +", " + programGraphEdge.toString() + ", " + programGraphEdge.getEndNode().toString() +") = ";

        if(killSetLV != null){
            slv += killSetLV.toString() + "\n";
        }
        else {
            slv += "{ } \n";
        }
        slv += "GenLV(" + programGraphEdge.getOriginNode().toString() +", " + programGraphEdge.toString() + ", " + programGraphEdge.getEndNode().toString() +") = ";

        if(genSetLV != null){
            slv += genSetLV.toString() + "\n";
        }
        else {
            slv += "{ }" +"\n";
        }
        return slv;
    }
}
