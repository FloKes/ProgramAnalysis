package microC.MonotoneAnalyses.Algorithms.Worklists;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Stack;

public class LIFOWorklist implements Worklist {
    private Stack<ProgramGraphNode> worklist;

    public void empty() {
        worklist = new Stack<>();
    }


    public void insert(ProgramGraphNode programGraphNode) {
        worklist.push(programGraphNode);
    }


    public ProgramGraphNode extract() {
        var node = worklist.pop();
        return node;
    }

    @Override
    public boolean isEmpty() {
        return worklist.isEmpty();
    }
}
