package microC.ProgramGraph;

import microC.BitVectorAnalysis.LiveVariables.Constraints.ConstraintLV;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.ConstraintRD;
import microC.MonotoneAnalyses.DangerousVariables.AnalysisAssignmentDV;
import microC.MonotoneAnalyses.ReachingDefinitions.AnalysisAssignmentRD;
import microC.MonotoneAnalyses.Interfaces.AnalysisAssignment;

import java.util.*;

public class ProgramGraphNode {
    private int number;
    private ProgramGraph programGraph;
    private List<ProgramGraphEdge> ingoingEdges;
    private List<ProgramGraphEdge> outgoingEdges;
    private ArrayList<ConstraintRD> constraintRDS;
    private ArrayList<ConstraintLV> constraintLVS;
    private AnalysisAssignmentRD analysisAssignmentRD;
    private AnalysisAssignmentDV analysisAssignmentDV;
    private HashMap<String, HashSet<Character>> DSMemory = new HashMap<>();

    public HashMap<String, HashSet<Character>> getDSMemory() {
        return DSMemory;
    }

    public void setDSMemory(HashMap<String, HashSet<Character>> DSMemory) {
        this.DSMemory = DSMemory;
    }

    public ProgramGraphNode(){
        //initial node
        this.number = 0;
        this.outgoingEdges = new LinkedList<ProgramGraphEdge>();
        this.constraintRDS = new ArrayList<>();
        this.constraintLVS = new ArrayList<>();
    }

    public ProgramGraphNode(int number) {
        this.number = number;
        this.ingoingEdges = new LinkedList<ProgramGraphEdge>();
        this.outgoingEdges = new LinkedList<ProgramGraphEdge>();
        this.constraintRDS = new ArrayList<>();
        this.constraintLVS = new ArrayList<>();
    }

    public ProgramGraphNode addEdgeOut(ProgramGraphEdge edge) {
        // When creating fresh edges check if node with number exists and increment if yes
        int newNodeNumber = this.number + 1;

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
        programGraph.addProgramGraphEdge(edge);

        //New node or the next in line
        return newNode;
    }

    public ProgramGraphNode addEdgeOut(ProgramGraphEdge edge, ProgramGraphNode node) {
        edge.setOriginNode(this);
        edge.setEndNode(node);

        this.outgoingEdges.add(edge);
        node.addEdgeIn(edge);
        programGraph.addProgramGraphEdge(edge);

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

    public ProgramGraph getProgramGraph() {
        return programGraph;
    }

    public boolean isFinalNode(){
        return this.outgoingEdges.isEmpty();
    }

    public boolean isOriginNode() {return this.ingoingEdges == null || this.ingoingEdges.isEmpty();}

    public int getNumber(){
        return this.number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public void addConstraintRD(ConstraintRD constraintRD){
        this.constraintRDS.add(constraintRD);
    }
    public ArrayList<ConstraintRD> getConstraintsRD() {
        return constraintRDS;
    }

    public void addConstraintLV(ConstraintLV constraintLV){
        this.constraintLVS.add(constraintLV);
    }

    public ArrayList<ConstraintLV> getConstraintsLV() {
        return constraintLVS;
    }

    public String toString(){
        if (number == 0){
            return "qs";
        }
        if (outgoingEdges.isEmpty()){
            return "qe";
        }
        return "q" + number;
    }

    public void setAnalysisAssignmentRD(AnalysisAssignment analysisAssignmentRD) {
        this.analysisAssignmentRD = (AnalysisAssignmentRD) analysisAssignmentRD;
    }

    public void setAnalysisAssignment(AnalysisAssignment analysisAssignment){
        if (analysisAssignment instanceof AnalysisAssignmentRD)
        {
            this.analysisAssignmentRD = (AnalysisAssignmentRD) analysisAssignment;
        }
        else if(analysisAssignment instanceof AnalysisAssignmentDV){
            this.analysisAssignmentDV = (AnalysisAssignmentDV) analysisAssignment;
        }
    }

    public AnalysisAssignmentRD getAnalysisAssignmentRD() {
        return analysisAssignmentRD;
    }

    public AnalysisAssignmentDV getAnalysisAssignmentDV() {
        return analysisAssignmentDV;
    }
}