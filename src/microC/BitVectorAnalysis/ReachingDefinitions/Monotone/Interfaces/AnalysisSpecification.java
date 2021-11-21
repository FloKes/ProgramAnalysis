package microC.BitVectorAnalysis.ReachingDefinitions.Monotone.Interfaces;

import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphNode;

public interface AnalysisSpecification {
    public AnalysisAssignment getInitialElement();
    public AnalysisAssignment getBottom();
}
