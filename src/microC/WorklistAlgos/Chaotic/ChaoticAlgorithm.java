package microC.WorklistAlgos.Chaotic;

import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphNode;

public class ChaoticAlgorithm {
    private Worklist worklist;

    public ChaoticAlgorithm(Worklist worklist) {
        this.worklist = worklist;
    }

    public void run(ProgramGraph programGraph){
        for (ProgramGraphNode node : programGraph.getProgramGraphNodes()){
            worklist.insert(node);
        }

        while (worklist.getLength() > 0){
            var n = worklist.extract();
            int i = 0;
        }
    }
}
