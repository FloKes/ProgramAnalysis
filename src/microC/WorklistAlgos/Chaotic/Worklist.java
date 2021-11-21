package microC.WorklistAlgos.Chaotic;

import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;
import java.util.Random;

public class Worklist {

    private ArrayList<ProgramGraphNode> nodes;
    private Random random;

    public Worklist(){
        nodes = new ArrayList<>();
        random = new Random();
    }


    public Worklist insert(ProgramGraphNode node){
        nodes.add(node);
        return this;
    }

    public ProgramGraphNode extract()
    {
        int rn = random.nextInt(nodes.size());
        return nodes.remove(rn);
    }

    public int getLength(){
        return nodes.size();
    }
}
