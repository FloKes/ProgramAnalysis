package microC.MonotoneAnalyses.Algorithms.Worklists;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Random;

public interface Worklist {

    public void empty();

    public void insert(ProgramGraphNode programGraphNode);

    public ProgramGraphNode extract ();

    public boolean isEmpty();
}
