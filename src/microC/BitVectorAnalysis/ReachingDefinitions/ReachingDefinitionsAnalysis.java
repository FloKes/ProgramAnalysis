package microC.BitVectorAnalysis.ReachingDefinitions;

import MathOp.UniOp;
import com.kitfox.svg.A;
import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.ProgramGraph.EdgeInformation;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;
import java.util.ArrayList;

public class ReachingDefinitionsAnalysis {
    private KillGenSetGenerator killGenSetGenerator;
    private KillGenSetPrinter killGenSetPrinter;
    private ConstraintGenerator constraintGenerator;


    public ReachingDefinitionsAnalysis() {
        this.killGenSetGenerator = new KillGenSetGenerator();
        this.constraintGenerator = new ConstraintGenerator();
        this.killGenSetPrinter = new KillGenSetPrinter();
    }

    public ArrayList<String> getKillGenSets(ProgramGraph programGraph){
        var killGenSets = killGenSetGenerator.getKillGenSets(programGraph);
        return killGenSetPrinter.getKillGenSets(programGraph);
    }

    public ArrayList<String> getConstraints(ProgramGraph programGraph){
        return constraintGenerator.getConstraints(programGraph);
    }



}
