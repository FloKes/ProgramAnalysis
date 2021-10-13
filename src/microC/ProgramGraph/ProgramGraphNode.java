package microC.ProgramGraph;

import java.util.List;

import java.util.LinkedList;

public class ProgramGraphNode {
    int number;

    List<ProgramGraphEdge> ingoingEdges;
    List<ProgramGraphEdge> outgoingEdges;

    public ProgramGraphNode(){
        this.number = 0;
        this.outgoingEdges = new LinkedList<ProgramGraphEdge>();;
    }

    public ProgramGraphNode(int number) {
        this.number = number;
        this.ingoingEdges = new LinkedList<ProgramGraphEdge>();
        this.outgoingEdges = new LinkedList<ProgramGraphEdge>();
    }

    public ProgramGraphNode addEdgeOut(ProgramGraphEdge edge) {
        //TODO Create new node only if the next number this.number + 1 doesn't exist
        ProgramGraphNode newNode = new ProgramGraphNode(this.number+1);

        edge.setOrigin(this);
        edge.setEnd(newNode);

        this.outgoingEdges.add(edge);
        newNode.addEdgeIn(edge);

        //New node or the next in line
        return newNode;
    }

    public void addEdgeIn(ProgramGraphEdge edge){
        this.ingoingEdges.add(edge);
    }

    public List<ProgramGraphEdge> getInGoing(){
        return this.ingoingEdges;
    }

    public List<ProgramGraphEdge> getOutGoing(){
        return this.outgoingEdges;
    }

    public int getNumber(){
        return this.number;
    }

    public boolean isFinalNode(){
        return this.outgoingEdges.isEmpty();
    }
}