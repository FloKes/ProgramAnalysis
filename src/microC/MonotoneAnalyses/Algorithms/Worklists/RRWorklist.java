package microC.MonotoneAnalyses.Algorithms.Worklists;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class RRWorklist implements Worklist{
    private ArrayList<ProgramGraphNode> wurklist;
    private ArrayList<ProgramGraphNode> TheQ;
    private boolean Q = false;
    private boolean extraRound;

    public void empty(){
        wurklist = new ArrayList<>();
        TheQ = new ArrayList<>();
        extraRound = false;
    }

    public void insert(ProgramGraphNode programGraphNode){
        if(!Q){
           initQ(programGraphNode);
           Q = true;
        }
        wurklist.add(programGraphNode);
        extraRound = true;
    }

    public ProgramGraphNode extract(){
        if(wurklist.isEmpty()){
            wurklist = new ArrayList<ProgramGraphNode>(TheQ);
            extraRound = false;
        }
        return wurklist.remove(0);
    }

    public boolean isEmpty() {
        //return wurklist.isEmpty();
        return !extraRound;
    }

    private void initQ(ProgramGraphNode pp) {
        int count = pp.getProgramGraph().getEndNode().getNumber() + 1;

        for(int i = 0; i < count; i++){
            TheQ.add(pp.getProgramGraph().getProgramGraphNode(i));
        }
    }
}
