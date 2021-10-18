package microC.BitVectorAnalysis.ReachingDefinitions.KillGen;

import microC.ProgramGraph.ProgramGraphNode;

public class GenSetRD {
    public String text;
    public String generated;
    public ProgramGraphNode originNode;
    public ProgramGraphNode endNode;

    public GenSetRD(String generated) {
        this.generated = generated;
    }

    public GenSetRD(String generated, ProgramGraphNode originNode, ProgramGraphNode endNode) {
        this.generated = generated;
        this.originNode = originNode;
        this.endNode = endNode;
    }

    public String getGenerated() {
        return generated;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
