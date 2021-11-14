package microC.WorklistAlgos;

public class RDChaotic {

    public void run(){
        // Reaching definitions chaotic iteration algorithm
        // Initialize start node with all variables as -> ?, qstart
        // for each edge/node [q0, a, q*] do S_RD [q0, a, q*](R) = (R \ killRD()) U genRD()
        // i.e. generate the gen/kill constraints for all nodes
        // Then loop through all nodes in order (first to last) and for each one,
        // Ensure that S_RD[q0,a,q*](RD'(q0) is contained in RD'(q*)
        // Meaning; ensure that the RD of a given node is "contained" in the next node
        // If it is not contained, do RD'(q*) = RD'(q*) union S_RD [q0, a, q*](RD'q0)
        // Meaning; combine the reaching definition set of the origin node of the edge, with the dest
        // node of the edge. Basically, make sure that RD of given node is contained in the next node.
        // Remember that some nodes might have multiple children
        // Keep doing this for all nodes until all nodes are properly contained
        // Print the results?
    }
}
