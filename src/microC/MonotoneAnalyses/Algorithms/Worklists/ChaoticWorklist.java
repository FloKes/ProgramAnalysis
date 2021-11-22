package microC.MonotoneAnalyses.Algorithms.Worklists;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Random;


public class ChaoticWorklist implements Worklist{
    private ArrayList<ProgramGraphNode>  worklist;

    public void empty(){
        worklist = new ArrayList<>();
    }

    public void insert(ProgramGraphNode programGraphNode){
        worklist.add(programGraphNode);
    }

    public ProgramGraphNode extract (){
        Random random = new Random();
        var r = random.nextInt(worklist.size());
        var node = worklist.remove(r);
        return node;
    }

    public boolean isEmpty(){
        return worklist.isEmpty();
    }
}
