package microC.MonotoneAnalyses.Interfaces;

import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

public interface AnalysisSpecification {
    public AnalysisAssignment getInitialElement();
    public AnalysisAssignment getBottom();
    public boolean isUnder(AnalysisAssignment analysisAssignment1
            , AnalysisAssignment analysisAssignment2);

    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge
            , AnalysisAssignment analysisAssignment);

    public AnalysisAssignment join(AnalysisAssignment analysisAssignment1
            , AnalysisAssignment analysisAssignment2);

    public void setAnalysisAssignment(ProgramGraphNode programGraphNode, AnalysisAssignment analysisAssignment);
    public AnalysisAssignment getAnalysisAssignment(ProgramGraphNode programGraphNode);
    public void printSolution(ProgramGraph programGraph);
    public boolean isForwardAnalysis();
}
