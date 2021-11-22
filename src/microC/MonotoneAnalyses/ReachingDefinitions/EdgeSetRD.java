package microC.MonotoneAnalyses.ReachingDefinitions;

public class EdgeSetRD {
    private String originNode;
    private String endNode;

    public EdgeSetRD(String originNode, String endNode) {
        this.originNode = originNode;
        this.endNode = endNode;
    }

    public String getOriginNode() {
        return originNode;
    }

    public String getEndNode() {
        return endNode;
    }

    @Override
    public String toString(){
        return "(" + originNode + ", " + endNode + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final EdgeSetRD other = (EdgeSetRD) obj;
        if (!this.originNode.equals(other.getOriginNode())) {
            return false;
        }

        if (!this.endNode.equals(other.getEndNode())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + originNode.hashCode();
        result = prime * result + endNode.hashCode();
        return result;
    }

    public EdgeSetRD clone(){
        return new EdgeSetRD(originNode, endNode);
    }
}
