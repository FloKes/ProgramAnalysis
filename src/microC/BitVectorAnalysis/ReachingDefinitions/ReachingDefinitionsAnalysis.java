package microC.BitVectorAnalysis.ReachingDefinitions;

import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.AnalysisAssignmentGenerator;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolution;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolutionPrinter;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.Constraint;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.ConstraintGenerator;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.ConstraintPrinter;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetGenerator;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetPrinter;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetRD;
import microC.ProgramGraph.ProgramGraph;

import java.util.ArrayList;

public class ReachingDefinitionsAnalysis {
    private KillGenSetGenerator killGenSetGenerator;
    private KillGenSetPrinter killGenSetPrinter;
    private ConstraintGenerator constraintGenerator;
    private ConstraintPrinter constraintPrinter;
    private AnalysisAssignmentGenerator analysisAssignmentGenerator;


    public ReachingDefinitionsAnalysis() {
        this.killGenSetGenerator = new KillGenSetGenerator();
        this.killGenSetPrinter = new KillGenSetPrinter();
        this.constraintGenerator = new ConstraintGenerator();
        this.constraintPrinter = new ConstraintPrinter();
        this.analysisAssignmentGenerator = new AnalysisAssignmentGenerator();
    }

    public void doAnalysis(ProgramGraph programGraph){
        // Create KillGen sets for edges
        var killGenSets = killGenSetGenerator.getKillGenSets(programGraph);

        System.out.println("\n --------------------- \n");

        // Generate and print constraints
        var constraints = getConstraints(programGraph);
        for (String constraint: getConstraintsStrings(constraints)) {
            System.out.println(constraint);
        }

        System.out.println("\n --------------------- \n");

        // Print RD analysis assignment
        var constraintSolutions = getConstraintSolutions(programGraph);
        var constraintSolutionStrings = getConstraintSolutionStrings(constraintSolutions);
        for (String constraintSolutionString: constraintSolutionStrings) {
            System.out.println(constraintSolutionString);
        }

        int i = 0;
    }

    public ArrayList<ConstraintSolution> getConstraintSolutions(ProgramGraph programGraph){
        return analysisAssignmentGenerator.solveConstraints(programGraph);
    }

    public ArrayList<String> getConstraintSolutionStrings (ArrayList<ConstraintSolution> constraintSolutions){
        ArrayList<String> constraintSolutionStrings = new ArrayList<>();
        for (ConstraintSolution constraintSolution: constraintSolutions){
            constraintSolutionStrings.add(ConstraintSolutionPrinter.getConstraintSolutionString(constraintSolution));
        }
        return constraintSolutionStrings;
    }

    public ArrayList<Constraint> getConstraints(ProgramGraph programGraph){
        return constraintGenerator.getConstraints(programGraph);
    }

    public ArrayList<String> getConstraintsStrings(ArrayList<Constraint> constraints){
        var constraintsStrings = constraintPrinter.getConstraintStrings(constraints);
        return constraintsStrings;
    }

    public ArrayList<KillGenSetRD> getKillGenSets(ProgramGraph programGraph){
        return killGenSetGenerator.getKillGenSets(programGraph);
    }

    public ArrayList<String> getKillGenSetsStrings(ArrayList<KillGenSetRD> killGenSets){
        return killGenSetPrinter.getKillGenSetStrings(killGenSets);
    }
}
