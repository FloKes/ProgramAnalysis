package microC.ProgramGraph;

import java.util.List;

import java.util.LinkedList;

public class ProgramGraphNode {
    private int number;
    private ProgramGraph programGraph;
    private List<ProgramGraphEdge> ingoingEdges;
    private List<ProgramGraphEdge> outgoingEdges;

    public ProgramGraphNode(){
        //initial node
        this.number = 0;
        this.outgoingEdges = new LinkedList<ProgramGraphEdge>();
    }

    public ProgramGraphNode(int number) {
        this.number = number;
        this.ingoingEdges = new LinkedList<ProgramGraphEdge>();
        this.outgoingEdges = new LinkedList<ProgramGraphEdge>();
    }

    public ProgramGraphNode addEdgeOut(ProgramGraphEdge edge) {
        // When creating fresh edges check if node with number exists and increment if yes
        int newNodeNumber = this.number + 1;


        //TODO Check for gaps in program graph numbers and fill gaps


        // If node is not added to program graph it throws a NullPointerException when this method is called
        // The node MUST be added to the programGraph to create a reference
        try {
            while (programGraph.getExistingNodeNumbers().contains(newNodeNumber)){
                newNodeNumber++;
            }
        }catch (NullPointerException e){
            System.out.println("Program graph node has no reference to program graph\nAdd node to program graph when created");
            throw e;
        }

        ProgramGraphNode newNode = new ProgramGraphNode(newNodeNumber);

        edge.setOriginNode(this);
        edge.setEndNode(newNode);

        this.outgoingEdges.add(edge);
        newNode.addEdgeIn(edge);

        //New node or the next in line
        return newNode;
    }

    public ProgramGraphNode addEdgeOut(ProgramGraphEdge edge, ProgramGraphNode node) {
        edge.setOriginNode(this);
        edge.setEndNode(node);

        this.outgoingEdges.add(edge);
        node.addEdgeIn(edge);

        //New node or the next in line
        return node;
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

    public void clearIngoingEdges(){
        this.ingoingEdges.clear();
    }

    public void clearOutGoingEdges(){
        this.outgoingEdges.clear();
    }

    public void clearAll(){
        clearIngoingEdges();
        clearOutGoingEdges();
        this.programGraph = null;
    }

    public void setParentProgramGraph(ProgramGraph programGraph){
        this.programGraph = programGraph;
    }

    public boolean isFinalNode(){
        return this.outgoingEdges.isEmpty();
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }
}