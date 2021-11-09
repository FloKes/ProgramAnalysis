package microC.BitVectorAnalysis.LiveVariables.ConstraintSolver;

public final class ConstraintSolutionPrinterLV {
    private ConstraintSolutionPrinterLV(){}

    public static String getConstraintSolutionString(ConstraintSolutionLV constraintSolution){
        String s = "LV(" + constraintSolution.getProgramGraphNode().toString() + ") = ";
        if (constraintSolution.getSolutionSet() != null){
            s += constraintSolution.getSolutionSet().toString();
        }
        return s;
    }
}
