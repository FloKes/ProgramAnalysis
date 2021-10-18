package microC.BitVectorAnalysis.ReachingDefinitions;

public class KillSetRD {
    public String text;
//    public String originNode;
//    public String endNode;

    public KillSetRD(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
