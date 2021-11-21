package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import microC.BitVectorAnalysis.ReachingDefinitions.Monotone.Interfaces.AnalysisAssignment;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AnalysisAssignmentRD implements AnalysisAssignment {
    private HashMap<String, HashSet<EdgeSet>> mappings;
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
        var edgeSet = new EdgeSet(originNode, endNode);
        hashSet.clear();
        hashSet.add(edgeSet);
    }

//    public HashMap<String, HashSet<EdgeSet>> getHashMap() {
//        return hashMap;
//    }
//
//    public void addPowerset(String identifier, EdgeSet edgeSet){
//        hashMap.get(identifier);
//    }
//
//    public HashSet<EdgeSet> getEdgeSets(String identifier){
//        return hashMap.get(identifier);
//    }
}
