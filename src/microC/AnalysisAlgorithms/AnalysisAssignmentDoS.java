package microC.AnalysisAlgorithms;

import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashMap;
import java.util.HashSet;

public class AnalysisAssignmentDoS implements AnalysisAssignment {

    private HashMap<String, HashSet<Character>> memory;

    public HashMap<String, HashSet<Character>> getMemory() {
        return memory;
    }

    public AnalysisAssignmentDoS(HashMap<String, HashSet<Character>> memory){
        this.memory = memory;
    }

    @Override
    public void setProgramGraphNode(ProgramGraphNode programGraphNode) {

    }

    @Override
    public AnalysisAssignment clone() {
        var clonedMem = this.cloneMem(this.memory);

        return new AnalysisAssignmentDoS(clonedMem);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private HashMap<String, HashSet<Character>> cloneMem(HashMap<String, HashSet<Character>> mem){
        var newMem = new HashMap<String, HashSet<Character>>();
        for (var key: mem.keySet()) {
            var set = new HashSet<>(mem.get(key));
            newMem.put(key, set);
        }
        return newMem;
    }
}
