package microC.AnalysisAlgorithms;

import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.HashMap;


public class IntervalAnalysisAssignment implements AnalysisAssignment {

    private HashMap<String, Interval> memory;

    public HashMap<String, Interval> getMemory() {
        return memory;
    }

    public IntervalAnalysisAssignment(HashMap<String, Interval> memory) {
        this.memory = memory;
    }

    @Override
    public void setProgramGraphNode(ProgramGraphNode programGraphNode) {

    }

    @Override
    public AnalysisAssignment clone() {
        var newMem = new HashMap<String, Interval>();
        for (var key: memory.keySet()) {
            var val = memory.get(key);
            if(val.isBottom()){
                newMem.put(key, new Interval(true));
            }
            else{
                newMem.put(key, new Interval(val.getMin(), val.getMax()));
            }
        }
        return new IntervalAnalysisAssignment(newMem);
    }
}
