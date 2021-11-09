package microC.BitVectorAnalysis.ReachingDefinitions;

import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.AnalysisAssignmentGeneratorRD;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolutionRD;
import microC.BitVectorAnalysis.ReachingDefinitions.ConstraintSolution.ConstraintSolutionPrinterRD;
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
    private AnalysisAssignmentGeneratorRD analysisAssignmentGeneratorRD;


    public ReachingDefinitionsAnalysis() {
        this.killGenSetGeneratorRD = new KillGenSetGeneratorRD();
        this.killGenSetPrinter = new KillGenSetPrinterRD();
        this.constraintGenerator = new ConstraintGeneratorRD();
        this.constraintPrinterRD = new ConstraintPrinterRD();
        this.analysisAssignmentGeneratorRD = new AnalysisAssignmentGeneratorRD();
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

    public ArrayList<ConstraintSolutionRD> getConstraintSolutions(ProgramGraph programGraph){
        return analysisAssignmentGeneratorRD.solveConstraints(programGraph);
    }

    public ArrayList<String> getConstraintSolutionStrings (ArrayList<ConstraintSolutionRD> constraintSolutions){
        ArrayList<String> constraintSolutionStrings = new ArrayList<>();
        for (ConstraintSolutionRD constraintSolution: constraintSolutions){
            constraintSolutionStrings.add(ConstraintSolutionPrinterRD.getConstraintSolutionString(constraintSolution));
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

    public void printAnalysis(ArrayList<ConstraintSolutionRD> constraintSolutions){
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
