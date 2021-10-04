package microC.ProgramGraph;

import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;

public class AssignmentEdgeInfo extends EdgeInformation {
    private String label;
    private String identifier;
    private String type = "Assignment";

    public String getType(){
        return this.type;
    }

    public String getTarget() {
        return label;
    }

    public AssignmentEdgeInfo(String label, String identifier) {
        this.label = label;
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return label;
    }
}
