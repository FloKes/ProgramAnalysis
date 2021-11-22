package microC;

import antlr.MicroCLexer;
import antlr.MicroCParser;
import graphviz.DOTFileGenerator;
import microC.AnalysisAlgorithms.AnalysisAssignmentDoS;
import microC.AnalysisAlgorithms.DetectionOfSigns;
import microC.BitVectorAnalysis.LiveVariables.LiveVariablesAnalysis;
import microC.MonotoneAnalyses.Algorithms.*;
import microC.MonotoneAnalyses.Algorithms.Worklists.ChaoticWorklist;
import microC.MonotoneAnalyses.Algorithms.Worklists.FIFOWorklist;
import microC.MonotoneAnalyses.Algorithms.Worklists.LIFOWorklist;
import microC.MonotoneAnalyses.DangerousVariables.AnalysisSpecificationDV;
import microC.MonotoneAnalyses.LiveVariables.AnalysisSpecificationLV;
import microC.MonotoneAnalyses.ReachingDefinitions.AnalysisSpecificationRD;
import microC.BitVectorAnalysis.ReachingDefinitions.ReachingDefinitionsAnalysis;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphGenerator;
import microC.ProgramGraph.ProgramGraphNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


//based on tutorial: https://www.youtube.com/watch?v=dPWWcH5uM0g


public class Launch {

    public static void main(String[] arg) throws IOException {
        try {
            //String source = "micro_c.txt";
            String source = "tests/test.txt";
            CharStream cs = CharStreams.fromFileName(source);
            MicroCLexer lexer = new MicroCLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            MicroCParser parser = new MicroCParser(token);
            ParseTree tree = parser.program();

            ASTBuilderVisitor visitor = new ASTBuilderVisitor();
            var prog = visitor.visit(tree);
//            PrintVisitor pv = new PrintVisitor();
//            System.out.println(pv.visit((ProgramNode) prog));
//            ProgramGraphBuilderVisitor pg = new ProgramGraphBuilderVisitor();
//            var n = pg.visit((ProgramNode) prog);
//            int i = 0;

            // Generate program graph
            ProgramGraphGenerator programGraphGenerator = new ProgramGraphGenerator();
            ProgramGraph programGraph = programGraphGenerator.generateProgramGraph(prog);
            ArrayList<ProgramGraphNode> programGraphNodes = programGraph.getProgramGraphNodes();

            //Detection of Signs
            var initMem = new HashMap<String, HashSet<Character>>();
            var xMem = new HashSet<Character>();
            var yMem = new HashSet<Character>();
            xMem.add('-');
            xMem.add('0');
            xMem.add('+');
            yMem.add('0');
            //x = {-,0,+}, y = {0}
            initMem.put("x",xMem);
            initMem.put("y", yMem);
//
            AnalysisAssignmentDoS analysisAssignmentDoS = new AnalysisAssignmentDoS(initMem);


//            dsc.run(programGraph, initMem);

            // Output program graph to .dot file
            DOTFileGenerator dotFileGenerator = new DOTFileGenerator();
            dotFileGenerator.GenerateFile(programGraphNodes);


//            // Reach definitions analysis
//            ReachingDefinitionsAnalysis reachingDefinitionsAnalysis = new ReachingDefinitionsAnalysis();
//            reachingDefinitionsAnalysis.doAnalysis(programGraph);
//
//
            // Live variable analysis
            LiveVariablesAnalysis liveVariablesAnalysis = new LiveVariablesAnalysis();
            liveVariablesAnalysis.doAnalysis(programGraph);



            // New generalised algorithms
            DevelopmentAlgorithm dev = new DevelopmentAlgorithm();
            ChaoticAlgorithm chaoticAlgorithm = new ChaoticAlgorithm();
            WorklistAlgorithm worklistAlgorithm = new WorklistAlgorithm();

//            // DETECTION OF SIGNS
//            System.out.println("\n\n--------------\n Detection of signs \n---------------");
//            DetectionOfSigns dosSpec = new DetectionOfSigns(initMem);
//
//            System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Detection of Signs\n---------------\n");
//            worklistAlgorithm.execute(programGraph, dosSpec, new ChaoticWorklist());
            

            // REACHING DEFINITIONS
            System.out.println("\n\n--------------\n Reaching definition \n---------------");
            AnalysisSpecificationRD analysisSpecificationRD = new AnalysisSpecificationRD(programGraph);

            System.out.println("--------------\n CHAOTIC ALG for Reaching definitions \n---------------\n");
            chaoticAlgorithm.execute(programGraph, analysisSpecificationRD);

            System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new ChaoticWorklist());

            System.out.println("\n\n--------------\n LIFO SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new LIFOWorklist());

            System.out.println("\n\n--------------\n FIFO SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new FIFOWorklist());


            // DANGEROUS VARIABLES
            System.out.println("\n\n\n--------------\n Dangerous variables \n---------------");
            AnalysisSpecificationDV analysisSpecificationDV = new AnalysisSpecificationDV(programGraph);

            System.out.println("\n--------------\n CHAOTIC ALG for Dangerous variables  \n---------------\n");
            chaoticAlgorithm.execute(programGraph, analysisSpecificationDV);

            System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Dangerous variables \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new ChaoticWorklist());

            System.out.println("\n\n--------------\n LIFO SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new LIFOWorklist());

            System.out.println("\n\n--------------\n FIFO SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new FIFOWorklist());


            // LIVE VARIABLES
            System.out.println("\n\n\n--------------\n Live variables \n---------------");
            AnalysisSpecificationLV analysisSpecificationLV = new AnalysisSpecificationLV(programGraph);


            System.out.println("\n--------------\n CHAOTIC ALG for Live variables  \n---------------\n");
            chaoticAlgorithm.execute(programGraph, analysisSpecificationLV);


            System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Live variables \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new ChaoticWorklist());

            System.out.println("\n\n--------------\n LIFO SPEC GENERALISED WORKLIST ALG for Live variables \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new LIFOWorklist());

            System.out.println("\n\n--------------\n FIFO SPEC GENERALISED WORKLIST ALG for Live variables \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new FIFOWorklist());

            int i = 0;
        } catch (IOException e) {
            throw e;

        }
    }
}
