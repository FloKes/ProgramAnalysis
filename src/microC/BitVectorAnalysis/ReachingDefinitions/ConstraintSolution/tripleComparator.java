package microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution;

import java.util.Comparator;

public class tripleComparator implements Comparator<ConstraintTriple> {
    @Override
    public int compare(ConstraintTriple o1, ConstraintTriple o2) {
        return o1.getValue().compareToIgnoreCase(o2.getValue());
    }
}
