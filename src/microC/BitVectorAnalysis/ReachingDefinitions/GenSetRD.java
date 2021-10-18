package microC.BitVectorAnalysis.ReachingDefinitions;

public class GenSetRD {
    public String text;
    public String identifier;
    public String originNode;
    public String endNode;

    public GenSetRD(String text) {
        this.text = text;
    }

    public GenSetRD(String identifier, String originNode, String endNode) {
        this.identifier = identifier;
        this.originNode = originNode;
        this.endNode = endNode;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
