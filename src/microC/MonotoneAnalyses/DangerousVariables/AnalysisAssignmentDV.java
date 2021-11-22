package microC.MonotoneAnalyses.DangerousVariables;

import MathOp.UniOp;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.ReachingDefinitions.EdgeSetRD;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;

public class AnalysisAssignmentDV implements AnalysisAssignment {

    private HashSet<String> identifiers;

    public AnalysisAssignmentDV(HashSet<String> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public void setProgramGraphNode(ProgramGraphNode programGraphNode) {

    }

    public HashSet<String> getIdentifiers() {
        return identifiers;
    }

    @Override
    public AnalysisAssignment clone() {
        HashSet<String> newIdentifiers = new HashSet<>();
        for (String identifier: identifiers){
            newIdentifiers.add(identifier);
        }

        return new AnalysisAssignmentDV(newIdentifiers);
    }

    @Override
    public String toString()
    {
        String s = "{";
        for (String identifier: identifiers){
            s += identifier + ", ";
        }
        if (!identifiers.isEmpty())
        {
            s = s.substring(0, s.length() -2 );
        }
        s += "}";
        return s;
    }
}
