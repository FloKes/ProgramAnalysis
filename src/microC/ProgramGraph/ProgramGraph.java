package microC.ProgramGraph;

import java.util.ArrayList;

public class ProgramGraph {
    private ArrayList<ProgramGraphNode> programGraphNodes;

    public ProgramGraph() {
        this.programGraphNodes = new ArrayList<>();
    }

    public void addNode(ProgramGraphNode node){
        this.programGraphNodes.add(node);

        // Each gets has a reference of the program graph it belongs to
        node.setParentProgramGraph(this);
    }

    public ArrayList<ProgramGraphNode> getProgramGraphNodes(){
        return this.programGraphNodes;
    }

    public ProgramGraphNode getProgramGraphNode(int index){
        for (ProgramGraphNode programGraphNode: programGraphNodes){
            if (programGraphNode.getNumber() == index){
                return programGraphNode;
            }
        }
        return null;
    }

    public ArrayList<Integer> getExistingNodeNumbers(){
        ArrayList<Integer> existingNodeNumbers = new ArrayList<>();
        for(ProgramGraphNode programGraphNode: programGraphNodes){
            existingNodeNumbers.add(programGraphNode.getNumber());
        }
        return existingNodeNumbers;
    }

    public Boolean removeProgramGraphNode(ProgramGraphNode programGraphNode){
        this.programGraphNodes.remove(programGraphNode);
        return true;
    }
}
