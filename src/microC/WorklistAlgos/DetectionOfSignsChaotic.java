package microC.WorklistAlgos;

import microC.AnalysisAlgorithms.DetectionOfSigns;
import microC.ProgramGraph.ProgramGraph;

public class DetectionOfSignsChaotic {
    private DetectionOfSigns DS = new DetectionOfSigns();

    public void run(ProgramGraph pg){
        DS.GenerateConstraints(pg.getProgramGraphNodes());

        // Initialize start node with input constraints for all vars
        // Generate the for all nodes/edges
        // Then loop through all nodes in order (first to last) and for each one,
        // Ensure that S_DS[q0,a,q*](DS'(q0) is contained in DS'(q*)
        // Meaning; ensure that the DS of a given node is "contained" in the next node
        // If it is not contained, do DS'(q*) = DS'(q*) union S_DS [q0, a, q*](DS'q0)
        // Meaning; combine the DS set of the origin node of the edge, with the dest
        // node of the edge. Basically, make sure that DS of given node is contained in the next node.
        // Remember that some nodes might have multiple children
        // Keep doing this for all nodes until all nodes are properly contained
        // Print the results?
    }


}
