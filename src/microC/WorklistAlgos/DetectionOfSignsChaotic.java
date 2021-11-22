package microC.WorklistAlgos;

import microC.AnalysisAlgorithms.DetectionOfSigns;
import microC.ProgramGraph.ProgramGraph;

import java.util.HashMap;
import java.util.HashSet;

public class DetectionOfSignsChaotic {
    private DetectionOfSigns DS = new DetectionOfSigns();

    private boolean isContained(HashSet<Character> small, HashSet<Character> big){
        if(big == null || big.isEmpty()) return false;
        return big.containsAll(small);
    }

    public void run(ProgramGraph pg, HashMap<String, HashSet<Character>> initMemory){
        boolean isFirst = true;
        for (var node: pg.getProgramGraphNodes()) {
            if(isFirst){
                pg.getProgramGraphNode(0).setDSMemory(initMemory);
                isFirst = false;
            }else{
                var mem = node.getDSMemory();
                for (var s: initMemory.keySet()) {
                    mem.put(s, new HashSet<Character>());
                }
            }
        }

        boolean shouldContinue = true;
        while(shouldContinue){
            shouldContinue = false;
            for (var node: pg.getProgramGraphNodes()) {
                if(node.isFinalNode()){continue;}
                for (var edge: node.getOutGoing()) {
                    var memory =  DS.generateConstraints(node.getDSMemory(), edge.getEdgeInformation());
                    var nextMem = edge.getEndNode().getDSMemory();
                    for (var s : memory.keySet()) {
                        if(!isContained(memory.get(s), nextMem.get(s))){
                            shouldContinue = true;
                            nextMem.get(s).addAll(memory.get(s));
                        }
                    }
                }
            }
        }
        //Print memory
        for (var n : pg.getProgramGraphNodes()) {
            System.out.println("Node: " + n.toString());
            for (var s : n.getDSMemory().keySet()) {
                System.out.print(s + ": ");
                for (var k: n.getDSMemory().get(s)) {
                    System.out.print(k + ",");
                }
                System.out.println("");
            }
        }


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
