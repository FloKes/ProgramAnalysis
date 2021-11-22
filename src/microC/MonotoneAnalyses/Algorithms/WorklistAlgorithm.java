package microC.MonotoneAnalyses.Algorithms;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Random;

public interface WorklistAlgorithm {

    public ArrayList<ProgramGraphNode> empty();

    public ArrayList<ProgramGraphNode> insert(ProgramGraphNode programGraphNode);

    public ProgramGraphNode extract (ArrayList<ProgramGraphNode> worklist);

}
