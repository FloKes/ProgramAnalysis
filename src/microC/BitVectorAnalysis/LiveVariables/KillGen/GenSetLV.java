package microC.BitVectorAnalysis.LiveVariables.KillGen;

import java.util.ArrayList;

public class GenSetLV {
    private String text;
    private ArrayList<String> generated;

    public GenSetLV(ArrayList<String> generated) {
        this.generated = generated;
    }

    public ArrayList<String> getGenerated() {
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
