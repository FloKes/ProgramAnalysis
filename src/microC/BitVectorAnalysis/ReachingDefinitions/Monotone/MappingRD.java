package microC.BitVectorAnalysis.ReachingDefinitions.Monotone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MappingRD {
    private HashMap<String, HashSet<EdgeSet>> hashMap;

    public MappingRD(String identifier) {
        hashMap = new HashMap<>();
    }

    public HashMap<String, HashSet<EdgeSet>> getHashMap() {
        return hashMap;
    }

    public void setEdgeSet(String identifier, EdgeSet edgeSet){
        hashMap.get(identifier).clear();
        hashMap.get(identifier).add(edgeSet);
    }

    public void addEdgeSet(String identifier, EdgeSet edgeSet){
        hashMap.get(identifier).add(edgeSet);
    }

    public HashSet<EdgeSet> getEdgeSets(String identifier){
        return hashMap.get(identifier);
    }
}
