package microC.MonotoneAnalyses.LiveVariables;

import microC.MonotoneAnalyses.DangerousVariables.AnalysisAssignmentDV;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;

public class AnalysisAssignmentLV implements AnalysisAssignment {

    private HashSet<String> identifiers;

    public AnalysisAssignmentLV(HashSet<String> identifiers) {
        this.identifiers = identifiers;
    }

    public HashSet<String> getIdentifiers() {
        return identifiers;
    }

    @Override
    public void setProgramGraphNode(ProgramGraphNode programGraphNode) {

    }

    @Override
    public AnalysisAssignment clone() {
        HashSet<String> newIdentifiers = new HashSet<>();
        for (String identifier: identifiers){
            newIdentifiers.add(identifier);
        }

        return new AnalysisAssignmentLV(newIdentifiers);
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
