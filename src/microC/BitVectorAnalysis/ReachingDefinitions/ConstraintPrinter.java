package microC.BitVectorAnalysis.ReachingDefinitions;

import MathOp.UniOp;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class ConstraintPrinter {
    private ArrayList<String> constraintsStrings;
    private KillGenSetGenerator generator;

    public ConstraintPrinter() {
        this.constraintsStrings = new ArrayList<>();
    }

    public ArrayList<String> getConstraints(ArrayList<Constraint> constraints) {
        String s = "";
        for (Constraint constraint : constraints) {

            if(constraint.getOriginNode() == null){
                s = "RD(" + constraint.getNode().toString() + ") "
                + UniOp.supseteq + " {(x, ?, qs),(y, ?, qs)}";
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
