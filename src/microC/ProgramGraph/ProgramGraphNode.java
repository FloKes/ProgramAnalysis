package microC.ProgramGraph;

import java.util.List;

import java.util.LinkedList;

public class ProgramGraphNode {
    int number;

    List<ProgramGraphEdge> in;
    List<ProgramGraphEdge> out;

    public ProgramGraphNode(){
        this.number = 0;
        this.out = new LinkedList<ProgramGraphEdge>();;
    }

    public ProgramGraphNode(int number) {
        this.number = number;
        this.in = new LinkedList<ProgramGraphEdge>();
        this.out = new LinkedList<ProgramGraphEdge>();
    }

    public ProgramGraphNode addEdgeOut(ProgramGraphEdge edge) {
        //TODO Create new node only if the next number this.number + 1 doesn't exist
        ProgramGraphNode newNode = new ProgramGraphNode(this.number+1);

        edge.setOrigin(this);
        edge.setEnd(newNode);

        this.out.add(edge);
        newNode.addEdgeIn(edge);

        //New node or the next in line
        return newNode;
    }

    public void addEdgeIn(ProgramGraphEdge edge){
        this.in.add(edge);
    }
}