package microC.MonotoneAnalyses.ReachingDefinitions;

import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.MonotoneAnalyses.Interfaces.AnalysisSpecification;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashSet;
import java.util.TreeSet;

public class AnalysisSpecificationRD implements AnalysisSpecification {
    private HashSet<String> identifiers;

    public AnalysisSpecificationRD(ProgramGraph programGraph) {
        identifiers = new HashSet<>();
        identifiers.addAll(programGraph.getUsedIdentifiers());
        identifiers.addAll(programGraph.getUsedIndexIdentifiers());
    }

    @Override
    public AnalysisAssignment getInitialElement() {
        var aa = new AnalysisAssignmentRD(identifiers);
        for (String identifier: identifiers){
            aa.setEdgeSet(identifier, "?", "qs");
        }
        return aa;
    }


    @Override
    public AnalysisAssignment getBottom()
    {
        return new AnalysisAssignmentRD(identifiers);
    }


    @Override
    public AnalysisAssignment function(ProgramGraphEdge programGraphEdge, AnalysisAssignment analysisAssignment) {
        var newaa = (AnalysisAssignmentRD) analysisAssignment.clone();
        var mappings = newaa.getMappings();

        var defined = programGraphEdge.getEdgeInformation().getDefined();
        var declared = programGraphEdge.getEdgeInformation().getDeclared();

        if(defined instanceof VariableIdentifierExpressionNode){
            var edgesets = mappings.get(defined.toString());
            edgesets.clear();
            edgesets.add(new EdgeSetRD(programGraphEdge.getOriginNode().toString(), programGraphEdge.getEndNode().toString()));
        }
        if(defined instanceof ArrayIdentifierExpressionNode){
            var edgesets = mappings.get(defined.toString());
            if (declared instanceof ArrayIdentifierExpressionNode){
                edgesets.clear();
            }
            edgesets.add(new EdgeSetRD(programGraphEdge.getOriginNode().toString(), programGraphEdge.getEndNode().toString()));
        }
        if(defined instanceof RecordIdentifierExpressionNode){;
            var recordIdentifier = (RecordIdentifierExpressionNode) defined;

            if ((recordIdentifier.getFst() == null && recordIdentifier.getSnd() == null) || declared instanceof RecordIdentifierExpressionNode){
                var edgesetsFst = mappings.get(defined.toString() + ".fst");
                edgesetsFst.clear();
                edgesetsFst.add(new EdgeSetRD(programGraphEdge.getOriginNode().toString(), programGraphEdge.getEndNode().toString()));

                var edgesetsSnd = mappings.get(defined.toString() + ".snd");
                edgesetsSnd.clear();
                edgesetsSnd.add(new EdgeSetRD(programGraphEdge.getOriginNode().toString(), programGraphEdge.getEndNode().toString()));
            }
            else if(recordIdentifier.getFst() != null){
                var edgesets = mappings.get(recordIdentifier.getIdentifier() +  ".fst");
                edgesets.clear();
                edgesets.add(new EdgeSetRD(programGraphEdge.getOriginNode().toString(), programGraphEdge.getEndNode().toString()));
            }
            else if (recordIdentifier.getSnd() != null){
                var edgesets = mappings.get(recordIdentifier.getIdentifier() +  ".snd");
                edgesets.clear();
                edgesets.add(new EdgeSetRD(programGraphEdge.getOriginNode().toString(), programGraphEdge.getEndNode().toString()));
            }
        }

        return newaa;
    }

    @Override
    public boolean isSubset(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var rd1 = (AnalysisAssignmentRD) analysisAssignment1;
        var rd2 = (AnalysisAssignmentRD) analysisAssignment2;

        var mappings1 = rd1.getMappings();
        var mappings2 = rd2.getMappings();

        for (String identifier: mappings2.keySet()){
            var edgesets1 = mappings1.get(identifier);
            var edgesets2 = mappings2.get(identifier);

            for (EdgeSetRD edgeSet: edgesets1){
                for (EdgeSetRD edgeSet2: edgesets2){
                    var z = edgeSet.equals(edgeSet2);
                    int bz = 0;
                }
                if (!edgesets2.contains(edgeSet)){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public AnalysisAssignment join(AnalysisAssignment analysisAssignment1, AnalysisAssignment analysisAssignment2) {
        var joined = (AnalysisAssignmentRD)analysisAssignment1.clone();
        var clone2 = (AnalysisAssignmentRD)analysisAssignment2.clone();
        var mappings1 = joined.getMappings();
        var mappings2 = clone2.getMappings();
        for (String identifier: mappings1.keySet()){
            var edgeSets = mappings1.get(identifier);
            for (EdgeSetRD edgeSet: mappings2.get(identifier)){
                edgeSets.add(edgeSet);
            }
        }
        return joined;
    }



    @Override
    public void setAnalysisAssignment(ProgramGraphNode programGraphNode, AnalysisAssignment analysisAssignment) {
        analysisAssignment.setProgramGraphNode(programGraphNode);
        programGraphNode.setAnalysisAssignment(analysisAssignment);
    }

    @Override
    public AnalysisAssignment getAnalysisAssignment(ProgramGraphNode programGraphNode) {
        return programGraphNode.getAnalysisAssignmentRD();
    }

    @Override
    public void printSolution(ProgramGraph programGraph) {
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()){
            System.out.println("RD(" + programGraphNode.toString() + ") = " + programGraphNode.getAnalysisAssignmentRD().toString());
        }
    }

//    @Override
//    public void printSolution(ProgramGraph programGraph) {
//        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()){
//            System.out.println("RD(" + programGraphNode.toString() + ") = " + "\n" + programGraphNode.getAnalysisAssignmentRD().toString());
//        }
//    }

    @Override
    public boolean isForwardAnalysis() {
        return true;
    }
}
