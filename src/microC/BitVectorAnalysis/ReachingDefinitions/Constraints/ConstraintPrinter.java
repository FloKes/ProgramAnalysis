package microC.BitVectorAnalysis.ReachingDefinitions.Constraints;

import MathOp.UniOp;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetGeneratorRD;

import java.util.ArrayList;

public class ConstraintPrinter {
    private ArrayList<String> constraintsStrings;
    private KillGenSetGeneratorRD generator;

    public ConstraintPrinter() {
        this.constraintsStrings = new ArrayList<>();
    }

    public ArrayList<String> getConstraintStrings(ArrayList<Constraint> constraints) {
        String s = "";
        for (Constraint constraint : constraints) {
            if(constraint.getOriginNode() == null){
                var programGraph = constraint.getNode().getProgramGraph();
                s = "RD(" + constraint.getNode().toString() + ") "
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
                s = "RD(" + constraint.getNode().toString() + ") " + UniOp.supseteq
                        + " (RD(" + constraint.getOriginNode().toString() + ")\\("
                        + constraint.getKilledString() + ")) "
                        + UniOp.union + " " + constraint.getGeneratedString()
                ;
                constraintsStrings.add(s);
            }
        }
        return constraintsStrings;
    }
}
