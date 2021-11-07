package microC.BitVectorAnalysis.ReachingDefinitions;

import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.AnalysisAssignmentGenerator;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolution;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolutionPrinter;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.ConstraintGeneratorRD;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.ConstraintPrinterRD;
import microC.BitVectorAnalysis.ReachingDefinitions.Constraints.ConstraintRD;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetGeneratorRD;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetPrinterRD;
import microC.BitVectorAnalysis.ReachingDefinitions.KillGen.KillGenSetRD;
import microC.ProgramGraph.ProgramGraph;

import java.util.ArrayList;

public class ReachingDefinitionsAnalysis {
    private KillGenSetGeneratorRD killGenSetGeneratorRD;
    private KillGenSetPrinterRD killGenSetPrinter;
    private ConstraintGeneratorRD constraintGenerator;
    private ConstraintPrinterRD constraintPrinterRD;
    private AnalysisAssignmentGenerator analysisAssignmentGenerator;


    public ReachingDefinitionsAnalysis() {
        this.killGenSetGeneratorRD = new KillGenSetGeneratorRD();
        this.killGenSetPrinter = new KillGenSetPrinterRD();
        this.constraintGenerator = new ConstraintGeneratorRD();
        this.constraintPrinterRD = new ConstraintPrinterRD();
        this.analysisAssignmentGenerator = new AnalysisAssignmentGenerator();
    }

    public void doAnalysis(ProgramGraph programGraph){
        System.out.println("\n \n -----------------\n REACHING DEFINITIONS ANALYSIS " +
                "\n---------------------");

        // Generate and print KilLGenSets
        var killGenSets = killGenSetGeneratorRD.generateKillGenSets(programGraph);
        printKillGenSets(killGenSets);

        // Generate and print Constraints
        var constraints = getConstraints(programGraph);
        printConstraints(constraints);

        // Generate and print Analysis
        var constraintSolutions = getConstraintSolutions(programGraph);
        printAnalysis(constraintSolutions);

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

    public ArrayList<ConstraintRD> getConstraints(ProgramGraph programGraph){
        return constraintGenerator.getConstraints(programGraph);
    }

    public ArrayList<String> getConstraintsStrings(ArrayList<ConstraintRD> constraintRDS){
        var constraintsStrings = constraintPrinterRD.getConstraintStrings(constraintRDS);
        return constraintsStrings;
    }

    public void printKillGenSets(ArrayList<KillGenSetRD> killGenSets){
        var strings = getKillGenSetsStrings(killGenSets);
        System.out.println("Kill Gen Sets for RD: \n ");
        for (String str: strings){
            System.out.println(str);
        }
    }

    public void printConstraints(ArrayList<ConstraintRD> constraints){
        System.out.println("\n --------------------- \n");
        System.out.println("Constraints for RD: \n");
        for (String constraint: getConstraintsStrings(constraints)) {
            System.out.println(constraint);
        }
    }

    public void printAnalysis(ArrayList<ConstraintSolution> constraintSolutions){
        System.out.println("\n --------------------- \n");
        System.out.println("Analysis assignment for RD: \n");
        for (String constraintSolutionString: getConstraintSolutionStrings(constraintSolutions)) {
            System.out.println(constraintSolutionString);
        }
    }
    public ArrayList<KillGenSetRD> getKillGenSets(ProgramGraph programGraph){
        return killGenSetGeneratorRD.generateKillGenSets(programGraph);
    }

    public ArrayList<String> getKillGenSetsStrings(ArrayList<KillGenSetRD> killGenSets){
        return killGenSetPrinter.getKillGenSetStrings(killGenSets);
    }
}
