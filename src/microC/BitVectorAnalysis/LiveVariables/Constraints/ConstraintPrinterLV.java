package microC.BitVectorAnalysis.LiveVariables.Constraints;

import MathOp.UniOp;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetGeneratorLV;

import java.util.ArrayList;

public class ConstraintPrinterLV {
    private ArrayList<String> constraintsStrings;
    private KillGenSetGeneratorLV generator;

    public ConstraintPrinterLV() {
        this.constraintsStrings = new ArrayList<>();
    }

    public ArrayList<String> getConstraintStrings(ArrayList<ConstraintLV> constraintLVS) {
        String s = "";
        for (ConstraintLV constraintLV : constraintLVS) {
            if (constraintLV.getEndNode() == null) {
                s = "LV(" + constraintLV.getNode().toString() + ") " + UniOp.supseteq + " { }";
                constraintsStrings.add(s);
            } else {
                s = "LV(" + constraintLV.getNode().toString() + ") " + UniOp.supseteq
                        + " (LV(" + constraintLV.getEndNode().toString() + ")\\"
                        + constraintLV.getKilledString() + ") "
                        + UniOp.union + " " + constraintLV.getGeneratedString()
                ;
                constraintsStrings.add(s);
            }
        }
        return constraintsStrings;
    }
}
