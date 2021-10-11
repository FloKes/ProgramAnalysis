package microC.ProgramGraph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String label;
    private EdgeInformation edgeInfo;

    //"from" is the edge that comes from the parent Node
    //"to" is the edge that goes to the child Node *FALSE* branch for boolean statements
    //"alternativeTo" is for boolean statement nodes that have two possible edges *TRUE branch*
    private Edge from = null, to = null, alternativeTo = null;

    public Node(String label, EdgeInformation edgeInfo) {
        this.label = label;
        this.edgeInfo = edgeInfo;
    }

    public Edge getAlternativeTo() {
        return alternativeTo;
    }

    public void setAlternativeTo(Edge alternativeTo) {
        this.alternativeTo = alternativeTo;
    }

    public EdgeInformation getEdgeInfo() {
        return edgeInfo;
    }

    public String getLabel() {
        return label;
    }

    public Edge getFrom() {
        return from;
    }

    public void setFrom(Edge from) {
        this.from = from;
    }

    public Edge getTo() {
        return to;
    }

    public void setTo(Edge to) {
        this.to = to;
    }

}
