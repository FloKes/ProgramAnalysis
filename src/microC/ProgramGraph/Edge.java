package microC.ProgramGraph;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    private String label;
    private EdgeInformation edgeInformation;
    private Node parentNode; //The node that the edge comes from
    private Node childNode; //The node that the edges is directed to

    public Edge(EdgeInformation edgeInformation, Node parent, Node child){
        this.edgeInformation = edgeInformation;
        this.label = edgeInformation.toString();
        this.parentNode = parent;
        this.childNode = child;
    }
    
    public void addParentNode(Node node){
        this.parentNode = node;
    }

    public void addChildNode(Node node){
        this.childNode = node;
    }
    
    public Node getParentNode(){
        return parentNode;
    }
    
    public Node getChildNode(){
        return childNode;
    }
}
