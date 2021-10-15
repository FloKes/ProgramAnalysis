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

        fillGapsInNodeNumbers(existingNodeNumbers);
        return existingNodeNumbers;
    }

    public void fillGapsInNodeNumbers(ArrayList<Integer> existingNodeNumbers){
        for (int i = 1; i < existingNodeNumbers.size(); i++){
            int gapSize = existingNodeNumbers.get(i)-existingNodeNumbers.get(i-1);
            if(gapSize > 1){
                for (int j = i; j < existingNodeNumbers.size(); j++){
                    programGraphNodes.get(j).setNumber(j);
                    existingNodeNumbers.set(j, j);
                }
            }
        }
    }

    public Boolean removeProgramGraphNode(ProgramGraphNode programGraphNode){
        this.programGraphNodes.remove(programGraphNode);
        return true;
    }
}
