package microC.BitVectorAnalysis.ReachingDefinitions.Constraints;

import MathOp.UniOp;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetGeneratorRD;

import java.util.ArrayList;

public class ConstraintPrinterRD {
    private ArrayList<String> constraintsStrings;
    private KillGenSetGeneratorRD generator;

    public ConstraintPrinterRD() {
        this.constraintsStrings = new ArrayList<>();
    }

    public ArrayList<String> getConstraintStrings(ArrayList<ConstraintRD> constraintRDS) {
        String s = "";
        for (ConstraintRD constraintRD : constraintRDS) {
            if(constraintRD.getOriginNode() == null){
                var programGraph = constraintRD.getNode().getProgramGraph();
                s = "RD(" + constraintRD.getNode().toString() + ") "
                + UniOp.supseteq + " {";

                for (int i = 0; i < programGraph.getDeclaredObjects().size(); i++) {
                    if ( i != programGraph.getDeclaredObjects().size()-1) {
                        s = s + "(" + programGraph.getDeclaredObjects().get(i) + ", ?, qs),";
                    }
                    else {
                        s = s + "(" + programGraph.getDeclaredObjects().get(i) + ", ?, qs)}";
                    }
                }
                constraintsStrings.add(s);
            }
            else {
                s = "RD(" + constraintRD.getNode().toString() + ") " + UniOp.supseteq
                        + " (RD(" + constraintRD.getOriginNode().toString() + ")\\("
                        + constraintRD.getKilledString() + ")) "
                        + UniOp.union + " " + constraintRD.getGeneratedString()
                ;
                constraintsStrings.add(s);
            }
        }
        return constraintsStrings;
    }
}
