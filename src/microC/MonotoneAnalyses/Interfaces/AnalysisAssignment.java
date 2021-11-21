package microC.MonotoneAnalyses.Interfaces;

import microC.ProgramGraph.ProgramGraphNode;

public interface AnalysisAssignment {
    public void setProgramGraphNode(ProgramGraphNode programGraphNode);

    public AnalysisAssignment clone();

    @Override
    public String toString();
}
