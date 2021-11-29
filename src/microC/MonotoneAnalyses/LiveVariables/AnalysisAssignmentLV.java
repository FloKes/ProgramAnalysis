package microC.MonotoneAnalyses.LiveVariables;

import microC.MonotoneAnalyses.DangerousVariables.AnalysisAssignmentDV;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;
import java.util.TreeSet;

public class AnalysisAssignmentLV implements AnalysisAssignment {

    private TreeSet<String> identifiers;

    public AnalysisAssignmentLV(TreeSet<String> identifiers) {
        this.identifiers = identifiers;
    }

    public TreeSet<String> getIdentifiers() {
        return identifiers;
    }

    @Override
    public void setProgramGraphNode(ProgramGraphNode programGraphNode) {

    }

    @Override
    public AnalysisAssignment clone() {
        TreeSet<String> newIdentifiers = new TreeSet<>();
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
