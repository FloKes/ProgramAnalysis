package microC.ProgramGraph;

import microC.Expressions.ExpressionNode;
import microC.Expressions.IdentifierExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;

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

    public HashSet<String> getUsedIdentifiers()
    {
        HashSet<String> identifiers = new HashSet<>();
        for (ProgramGraphEdge edge: this.getProgramGraphEdges()){
            if (edge.getEdgeInformation().getDefined() != null) {
                if(!(edge.getEdgeInformation().getDefined() instanceof RecordIdentifierExpressionNode)) {
                    identifiers.add(edge.getEdgeInformation().getDefined().toString());
                }
                else {
                    var defined = (RecordIdentifierExpressionNode) edge.getEdgeInformation().getDefined();
                    if (defined.getFst() == null && defined.getSnd() == null){
                        identifiers.add(defined.toString() + ".fst");
                        identifiers.add(defined.toString() + ".snd");
                    }
                    else if(defined.getFst()!= null){
                        identifiers.add(defined.toString() + ".fst");
                    }
                    else if(defined.getSnd()!= null){
                        identifiers.add(defined.toString() + ".snd");
                    }
                }
            }
            var expression = edge.getEdgeInformation().getEdgeExpression().getVariablesUsed();
            for (ExpressionNode expressionNode: expression){
                if (expressionNode instanceof IdentifierExpressionNode){
                    if(expressionNode instanceof RecordIdentifierExpressionNode){
                        var record = (RecordIdentifierExpressionNode)expressionNode;
                        if(record.getFst()!= null){
                            identifiers.add(record.toString() + ".fst");
                        }
                        else if(record.getSnd()!= null){
                            identifiers.add(record.toString() + ".snd");
                        }
                    }
                    else {
                        identifiers.add(((IdentifierExpressionNode) expressionNode).toString());
                    }
                }
            }
        }
        return identifiers;
    }

    public HashSet<String> getUsedIndexIdentifiers()
    {
        HashSet<String> indexIdentifiers = new HashSet<>();
        for (ProgramGraphEdge edge: this.getProgramGraphEdges()){
            var arrayIndexObjectsUsed = edge.getEdgeInformation().getEdgeExpression().getArrayIndexObjectsUsed();
            if (arrayIndexObjectsUsed == null){
                return indexIdentifiers;
            }
            for (ExpressionNode expressionNode: arrayIndexObjectsUsed){
                if (expressionNode instanceof IdentifierExpressionNode){
                    if(expressionNode instanceof RecordIdentifierExpressionNode){
                        var record = (RecordIdentifierExpressionNode)expressionNode;
                        if(record.getFst()!= null){
                            indexIdentifiers.add(record.toString() + ".fst");
                        }
                        else if(record.getSnd()!= null){
                            indexIdentifiers.add(record.toString() + ".snd");
                        }
                    }
                    else {
                        indexIdentifiers.add(((IdentifierExpressionNode) expressionNode).toString());
                    }
                }
            }
        }
        return indexIdentifiers;
    }

    public void sort(){
        var endNode = getEndNode();
        var endNodeIndex = programGraphNodes.indexOf(endNode);
        var correctIndex = programGraphNodes.size() - 1;

        programGraphNodes.remove(endNode);
        for(int i = endNodeIndex; i < programGraphNodes.size(); i++){
            programGraphNodes.get(i).setNumber(i);
        }

        endNode.setNumber(correctIndex);
        programGraphNodes.add(endNode);
    }

    public ProgramGraphNode getEndNode(){
        for (ProgramGraphNode programGraphNode: this.getProgramGraphNodes()){
            if (programGraphNode.isFinalNode()){
                return programGraphNode;
            }
        }
        return null;
    }
}
