package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import MathOp.UniOp;
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

    public AnalysisAssignmentRD(HashMap<String, HashSet<EdgeSet>> mappings)
    {
        HashMap<String, HashSet<EdgeSet>> newMappings = new HashMap<>();
        for (String identifier: mappings.keySet()){
            var oldHashEdgeSet = mappings.get(identifier);
            HashSet<EdgeSet> newHashEdgeSet = new HashSet<>();

            for (EdgeSet edgeSet: oldHashEdgeSet){
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
        var edgeSet = new EdgeSet(originNode, endNode);
        hashSet.clear();
        hashSet.add(edgeSet);
    }



    public HashMap<String, HashSet<EdgeSet>> getMappings() {
        return mappings;
    }

    @Override
    public String toString()
    {
        String s = "";
        for (String identifer: mappings.keySet()) {
            s += "| " + identifer + " " + UniOp.function + " ";
            s += "{";
            for (EdgeSet edgeSet : mappings.get(identifer)) {
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
