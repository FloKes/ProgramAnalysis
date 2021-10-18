package microC.BitVectorAnalysis.ReachingDefinitions;

import microC.ProgramGraph.ProgramGraph;

import java.util.ArrayList;

public class ReachingDefinitionsAnalysis {
    private KillGenSetGenerator killGenSetGenerator;
    private KillGenSetPrinter killGenSetPrinter;
    private ConstraintGenerator constraintGenerator;
    private ConstraintPrinter constraintPrinter;


    public ReachingDefinitionsAnalysis() {
        this.killGenSetGenerator = new KillGenSetGenerator();
        this.killGenSetPrinter = new KillGenSetPrinter();
        this.constraintGenerator = new ConstraintGenerator();
        this.constraintPrinter = new ConstraintPrinter();
    }

    public void doAnalysis(ProgramGraph programGraph){
        var killGenSets = killGenSetGenerator.getKillGenSets(programGraph);
        var constraints = constraintGenerator.getConstraints(programGraph);
        int i = 0;
    }


    public ArrayList<KillGenSetRD> getKillGenSets(ProgramGraph programGraph){
        return killGenSetGenerator.getKillGenSets(programGraph);
    }

    public ArrayList<String> getKillGenSetsStrings(ArrayList<KillGenSetRD> killGenSets){
        return killGenSetPrinter.getKillGenSetStrings(killGenSets);
    }

    public ArrayList<Constraint> getConstraints(ProgramGraph programGraph){
        return constraintGenerator.getConstraints(programGraph);
    }

    public ArrayList<String> getConstraintsStrings(ArrayList<Constraint> constraints){
        var constraintsStrings = constraintPrinter.getConstraints(constraints);
        return constraintsStrings;
    }



}
