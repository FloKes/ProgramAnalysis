package microC.MonotoneAnalyses.Algorithms.Worklists;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Collections;

public class rPWorklist implements Worklist {
    private ArrayList<ProgramGraphNode> CurrentNodes;
    private ArrayList<ProgramGraphNode> PendingNodes;

    public void empty(){
        CurrentNodes = new ArrayList<>();
        PendingNodes = new ArrayList<>();
    }

    public void insert(ProgramGraphNode programGraphNode){
        boolean isIn = false;

        for(int i = 0; i < CurrentNodes.size(); i++){
            if(programGraphNode == CurrentNodes.get(i)){
                isIn = true;
                break;
            }
        }

        if(!isIn){
            PendingNodes.add(programGraphNode);
        }
    }

    public ProgramGraphNode extract (){
        if(CurrentNodes.isEmpty()){
            SortingAlgo();
            CurrentNodes = new ArrayList<ProgramGraphNode>(PendingNodes);
            PendingNodes.clear();
        }

        var node = CurrentNodes.remove(0);
        return node;
    }

    public boolean isEmpty(){
        return CurrentNodes.isEmpty() && PendingNodes.isEmpty();
    }

    private void SortingAlgo(){
        int n = PendingNodes.size();

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (PendingNodes.get(j).getNumber() > PendingNodes.get(j + 1).getNumber()) {
                    // swap PendingNode[j+1] and PendingNode[j]
                    Collections.swap(PendingNodes, j, j + 1);
                }
            }
        }
    }
}