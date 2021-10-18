package microC.BitVectorAnalysis.ReachingDefinitions;

public class GenSetRD {
    public String text;
    public String generated;
    public String originNode;
    public String endNode;

    public GenSetRD(String generated) {
        this.generated = generated;
    }

    public GenSetRD(String generated, String originNode, String endNode) {
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
