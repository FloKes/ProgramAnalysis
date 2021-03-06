package microC.BitVectorAnalysis.ReachingDefinitions.KillGen;

public class KillSetRD {
    private String text;
    private String killed;

    public KillSetRD(String killed) {
        this.killed = killed;
    }

    public String getKilled() {
        return killed;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
