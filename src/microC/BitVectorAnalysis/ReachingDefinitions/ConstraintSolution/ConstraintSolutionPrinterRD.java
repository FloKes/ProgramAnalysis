package microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution;

public final class ConstraintSolutionPrinterRD {

    private ConstraintSolutionPrinterRD() {}

    public static String getConstraintSolutionString (ConstraintSolutionRD constraintSolution){
        String s = "RD(" + constraintSolution.getProgramGraphNode().toString() + ") = ";
        if(!constraintSolution.getConstraintTriples().isEmpty()) {
            s = s+ "{";
            for (int i = 0; i < constraintSolution.getConstraintTriples().size(); i++){
                if (i != constraintSolution.getConstraintTriples().size()-1){
                    s = s + constraintSolution.getConstraintTriples().get(i).toString() + ", ";
                }
                else {
                    s = s + constraintSolution.getConstraintTriples().get(i).toString();
                }
            }
            s = s + "}";
            return s;
        }
        s = s + "{ }";
        return s;
    }
}
