package microC.MonotoneAnalyses.ReachingDefinitions;

import MathOp.UniOp;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashMap;
import java.util.HashSet;

public class AnalysisAssignmentRD implements AnalysisAssignment {
    private HashMap<String, HashSet<EdgeSetRD>> mappings;
    private ProgramGraphNode programGraphNode;

    public AnalysisAssignmentRD(ProgramGraphNode programGraphNode) {
        this.programGraphNode = programGraphNode;
        mappings = new HashMap<>();

    }

    public AnalysisAssignmentRD(HashSet<String> identifiers) {
        mappings = new HashMap<>();
        for (String identifier: identifiers){
            mappings.put(identifier, new HashSet<>());
        }
    }

    public AnalysisAssignmentRD(HashMap<String, HashSet<EdgeSetRD>> mappings)
    {
        HashMap<String, HashSet<EdgeSetRD>> newMappings = new HashMap<>();
        for (String identifier: mappings.keySet()){
            var oldHashEdgeSet = mappings.get(identifier);
            HashSet<EdgeSetRD> newHashEdgeSet = new HashSet<>();

            for (EdgeSetRD edgeSet: oldHashEdgeSet){
                newHashEdgeSet.add(edgeSet.clone());
            }

            newMappings.put(identifier, newHashEdgeSet);
        }
        this.mappings = newMappings;
    }

    public void setProgramGraphNode(ProgramGraphNode programGraphNode)
    {
        this.programGraphNode = programGraphNode;
    }

    public void setBottom(HashSet<String> identifiers){
        for (java.lang.String identifier: identifiers)
        {
            mappings.put(identifier, new HashSet<>());
        }
    }

    public void setEdgeSet(String identifier, String originNode, String endNode){
        var hashSet = mappings.get(identifier);
        var edgeSet = new EdgeSetRD(originNode, endNode);
        hashSet.clear();
        hashSet.add(edgeSet);
    }


    public HashMap<String, HashSet<EdgeSetRD>> getMappings() {
        return mappings;
    }

    @Override
    public String toString()
    {
        String s = "";
        for (String identifer: mappings.keySet()) {
            s += "| " + identifer + " " + UniOp.function + " ";
            s += "{";
            for (EdgeSetRD edgeSet : mappings.get(identifer)) {
                s += edgeSet.toString() + ", ";
            }
            if (!mappings.get(identifer).isEmpty()){
                s = s.substring(0, s.length() - 2);
            }
            s += "}| \n";
        }
        return s;
    }

    @Override
    public AnalysisAssignment clone() {
        var clone = new AnalysisAssignmentRD(this.getMappings());
        return clone;
    }
}
