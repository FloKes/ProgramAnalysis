package microC.ProgramGraph;

import java.util.ArrayList;

public class ProgramGraph {
    private ArrayList<ProgramGraphNode> programGraph;

    public ProgramGraph() {
        this.programGraph = new ArrayList<>();
    }

    public void addNode(ProgramGraphNode node){
        this.programGraph.add(node);
    }

    public ArrayList<ProgramGraphNode> getProgramGraphNodes(){
        return this.programGraph;
    }

    public ProgramGraphNode getProgramGraphNode(int index){
        for (ProgramGraphNode programGraphNode: programGraph){
            if (programGraphNode.getNumber() == index){
                return programGraphNode;
            }
        }
        return null;
    }
}
