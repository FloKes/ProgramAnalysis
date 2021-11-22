package microC.MonotoneAnalyses.Algorithms.Worklists;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.*;

public class FIFOWorklist implements Worklist{

    private Queue<ProgramGraphNode> worklist;

    @Override
    public void empty() {
        worklist = new LinkedList();
    }

    @Override
    public void insert(ProgramGraphNode programGraphNode) {
        worklist.add(programGraphNode);
    }

    @Override
    public ProgramGraphNode extract() {
        return worklist.poll();
    }

    @Override
    public boolean isEmpty() {
        return worklist.isEmpty();
    }
}
