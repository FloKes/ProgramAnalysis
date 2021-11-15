package microC.AnalysisAlgorithms;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectionOfSigns {

    private HashMap<Integer, DSConstraint> constraintHashMap = new HashMap<>();

    public HashMap<Integer, DSConstraint> getConstraintHashMap() {
        return constraintHashMap;
    }

    public DSConstraint GenerateConstraints(ArrayList<ProgramGraphNode> nodes) {
        for (var node: nodes) {
            var constraint = new DSConstraint();

        }
        return null;
    }
}
