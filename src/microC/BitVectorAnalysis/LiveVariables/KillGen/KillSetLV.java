package microC.BitVectorAnalysis.LiveVariables.KillGen;

public class KillSetLV {
    private String killed;
    private String text;

    public KillSetLV(String killed) {
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
