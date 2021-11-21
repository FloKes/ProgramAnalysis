package microC.ProgramGraph;

import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;

import java.util.ArrayList;
import java.util.HashSet;

public class ProgramGraph {
    private ArrayList<ProgramGraphNode> programGraphNodes;
    private ArrayList<ProgramGraphEdge> programGraphEdges;
    private ArrayList<String> declaredObjects;

    public ProgramGraph() {
        this.programGraphNodes = new ArrayList<>();
        this.programGraphEdges = new ArrayList<>();
        this.declaredObjects = new ArrayList<>();
    }

    public void addNode(ProgramGraphNode node){
        this.programGraphNodes.add(node);

        // Each gets has a reference of the program graph it belongs to
        node.setParentProgramGraph(this);
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

    public void addDeclaredObjects(String object){
        this.declaredObjects.add(object);
    }

    public ArrayList<String> getDeclaredObjects() {
        return declaredObjects;
    }

    public ArrayList<ProgramGraphNode> getProgramGraphNodes(){
        return this.programGraphNodes;
    }

    public void addProgramGraphEdge (ProgramGraphEdge programGraphEdge){
        programGraphEdges.add(programGraphEdge);
    }
    public ArrayList<ProgramGraphEdge> getProgramGraphEdges() {
        return programGraphEdges;
    }

    public HashSet<String> getUsedObjects()
    {
        HashSet<String> identifiers = new HashSet<>();
        for (ProgramGraphEdge edge: this.getProgramGraphEdges()){
            if (edge.getEdgeInformation().getDefined() != null) {
                identifiers.add(edge.getEdgeInformation().getDefined().toString());
            }
            var expression = edge.getEdgeInformation().getEdgeExpression().getVariablesUsed();
            for (ExpressionNode expressionNode: expression){
                if (expressionNode instanceof IdentifierExpressionNode){
                    identifiers.add(((IdentifierExpressionNode) expressionNode).toString());
                }
            }
        }
        return identifiers;
    }
}
