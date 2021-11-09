package microC.BitVectorAnalysis.LiveVariables;

import microC.BitVectorAnalysis.LiveVariables.ConstraintSolver.AnalysisAssignmentGeneratorLV;
import microC.BitVectorAnalysis.LiveVariables.ConstraintSolver.ConstraintSolutionLV;
import microC.BitVectorAnalysis.LiveVariables.ConstraintSolver.ConstraintSolutionPrinterLV;
import microC.BitVectorAnalysis.LiveVariables.Constraints.ConstraintGeneratorLV;
import microC.BitVectorAnalysis.LiveVariables.Constraints.ConstraintLV;
import microC.BitVectorAnalysis.LiveVariables.Constraints.ConstraintPrinterLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetGeneratorLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetLV;
import microC.BitVectorAnalysis.LiveVariables.KillGen.KillGenSetPrinterLV;
import microC.ProgramGraph.ProgramGraph;

import java.util.ArrayList;

public class LiveVariablesAnalysis {
    private KillGenSetGeneratorLV killGenSetGenerator;
    private KillGenSetPrinterLV killGenSetPrinter;
    private ConstraintGeneratorLV constraintGenerator;
    private ConstraintPrinterLV constraintPrinter;
    private AnalysisAssignmentGeneratorLV analysisGenerator;

    public LiveVariablesAnalysis() {
        killGenSetGenerator = new KillGenSetGeneratorLV();
        killGenSetPrinter = new KillGenSetPrinterLV();
        constraintGenerator = new ConstraintGeneratorLV();
        constraintPrinter = new ConstraintPrinterLV();
        analysisGenerator = new AnalysisAssignmentGeneratorLV();
    }

    public void doAnalysis(ProgramGraph programGraph){
        System.out.println("\n \n -------------------\n LIVE VARIABLE ANALYSIS " +
                "\n-------------------");

        // Generate and print KilLGenSets
        var killGenSets = killGenSetGenerator.generateKillGenSets(programGraph);
        printKillGenSets(killGenSets);


        // Generate and print Constraints
        var constraints = getConstraints(programGraph);
        printConstraints(constraints);

        var constraintSolutions = analysisGenerator.solveConstraints(programGraph);
        printAnalysis(constraintSolutions);
    }

    public void printKillGenSets(ArrayList<KillGenSetLV> killGenSets){
        var strings = killGenSetPrinter.getKillGenSetStrings(killGenSets);
        System.out.println("Kill Gen Sets for LV: \n ");
        for (String str: strings){
            System.out.println(str);
        }
    }

    public void printConstraints(ArrayList<ConstraintLV> constraints){
        var strings = constraintPrinter.getConstraintStrings(constraints);
        System.out.println("\n --------------------- \n");
        System.out.println("Constraints for LV: \n ");
        for (String str: strings){
            System.out.println(str);
        }
    }

    public void printAnalysis(ArrayList<ConstraintSolutionLV> constraintSolutions) {
        System.out.println("\n --------------------- \n");
        System.out.println("Analysis assignment for LV: \n");
        for (ConstraintSolutionLV constraintSolution : constraintSolutions) {
            System.out.println(ConstraintSolutionPrinterLV.getConstraintSolutionString(constraintSolution));
        }
    }

    public ArrayList<ConstraintLV> getConstraints(ProgramGraph programGraph){
        return constraintGenerator.getConstraints(programGraph);
    }

    public ArrayList<String> getConstraintsStrings(ArrayList<ConstraintLV> constraintLVS){
        var constraintsStrings = constraintPrinter.getConstraintStrings(constraintLVS);
        return constraintsStrings;
    }

    public ArrayList<KillGenSetLV> getKillGenSets(ProgramGraph programGraph){
        var killGenSets = killGenSetGenerator.generateKillGenSets(programGraph);
        return killGenSets;
    }

    public ArrayList<String> getKillGenSetsStrings(ArrayList<KillGenSetLV> killGenSets){
        return killGenSetPrinter.getKillGenSetStrings(killGenSets);
    }
}
