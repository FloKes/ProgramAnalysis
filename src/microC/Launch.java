package microC;

import antlr.MicroCLexer;
import antlr.MicroCParser;
import graphviz.DOTFileGenerator;
import microC.AnalysisAlgorithms.*;
import microC.BitVectorAnalysis.LiveVariables.LiveVariablesAnalysis;
import microC.BitVectorAnalysis.ReachingDefinitions.ReachingDefinitionsAnalysis;
import microC.MonotoneAnalyses.Algorithms.ChaoticAlgorithm;
import microC.MonotoneAnalyses.Algorithms.DevelopmentAlgorithm;
import microC.MonotoneAnalyses.Algorithms.WorklistAlgorithm;
import microC.MonotoneAnalyses.Algorithms.Worklists.*;
import microC.MonotoneAnalyses.DangerousVariables.AnalysisSpecificationDV;
import microC.MonotoneAnalyses.LiveVariables.AnalysisSpecificationLV;
import microC.MonotoneAnalyses.ReachingDefinitions.AnalysisSpecificationRD;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphBuilderVisitor;
import microC.ProgramGraph.ProgramGraphGenerator;
import microC.ProgramGraph.ProgramGraphNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


//based on tutorial: https://www.youtube.com/watch?v=dPWWcH5uM0g


public class Launch {

    public static void main(String[] arg) throws IOException {
        try {
            //String source = "micro_c.txt";
            String source = "tests/test_factorial.txt";
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
//            var initMem = new HashMap<String, HashSet<Character>>();
//            var xMem = new HashSet<Character>();
//            var yMem = new HashSet<Character>();
//            xMem.add('-');
//            xMem.add('0');
//            xMem.add('+');
//            yMem.add('0');
//            //x = {-,0,+}, y = {0}
//            initMem.put("x",xMem);
//            initMem.put("R", yMem);

            //dsc.run(programGraph, initMem);

            // Output program graph to .dot file
            DOTFileGenerator dotFileGenerator = new DOTFileGenerator();
            dotFileGenerator.GenerateFile(programGraphNodes);


//            // Reach definitions analysis
            ReachingDefinitionsAnalysis reachingDefinitionsAnalysis = new ReachingDefinitionsAnalysis();
            reachingDefinitionsAnalysis.doAnalysis(programGraph);

            // Live variable analysis
            LiveVariablesAnalysis liveVariablesAnalysis = new LiveVariablesAnalysis();
            liveVariablesAnalysis.doAnalysis(programGraph);


            // New generalised algorithms
            DevelopmentAlgorithm dev = new DevelopmentAlgorithm();
            ChaoticAlgorithm chaoticAlgorithm = new ChaoticAlgorithm();
            WorklistAlgorithm worklistAlgorithm = new WorklistAlgorithm();


            var initIntMem = new HashMap<String, Interval>();
            var intSet = new HashSet<>(Arrays.asList(-1, 0, 10));
            var intervalSet = new IntervalSet(intSet);
            var xIntMem = new Interval("-1","10");
            var yIntMem = new Interval("-1","10");
            initIntMem.put("x", xIntMem);
            initIntMem.put("y", yIntMem);
            // INTERVAL ANALYSIS
            System.out.println("\n\n--------------\n Interval Analysis \n---------------");
            IntervalAnalysisSpecification intSpec = new IntervalAnalysisSpecification(initIntMem, intervalSet);

            System.out.println("\n\n--------------\n rP GENERALISED WORKLIST ALG for Interval Analysis\n---------------\n");
            worklistAlgorithm.execute(programGraph, intSpec, new rPWorklist());


            // DETECTION OF SIGNS
//          System.out.println("\n\n--------------\n Detection of signs \n---------------");
//          DetectionOfSigns dosSpec = new DetectionOfSigns(initMem);

            //System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Detection of Signs\n---------------\n");
            //worklistAlgorithm.execute(programGraph, dosSpec, new ChaoticWorklist());
            

            // REACHING DEFINITIONS
            System.out.println("\n\n--------------\n Reaching definition \n---------------");
            AnalysisSpecificationRD analysisSpecificationRD = new AnalysisSpecificationRD(programGraph);

            System.out.println("--------------\n CHAOTIC ALG for Reaching definitions \n---------------\n");
            chaoticAlgorithm.execute(programGraph, analysisSpecificationRD);

            System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new ChaoticWorklist());

//          System.out.println("\n\n--------------\n LIFO SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new LIFOWorklist());
//
//          System.out.println("\n\n--------------\n FIFO SPEC GENERALISED WORKLIST ALG for Reaching definitions \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new FIFOWorklist());
//
//          System.out.println("\n\n--------------\n ITERATIVE REVERSE POST ORDER WORKLIST for Reaching definitions \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new rPWorklist());
//
//          System.out.println("\n\n--------------\n ROUND ROBIN WORKLIST for Reaching definitions \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationRD, new RRWorklist());

//
//          // DANGEROUS VARIABLES
//          System.out.println("\n\n\n--------------\n Dangerous variables \n---------------");
//          AnalysisSpecificationDV analysisSpecificationDV = new AnalysisSpecificationDV(programGraph);
//
//          System.out.println("\n--------------\n CHAOTIC ALG for Dangerous variables  \n---------------\n");
//          chaoticAlgorithm.execute(programGraph, analysisSpecificationDV);
//
//          System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Dangerous variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new ChaoticWorklist());
//
//          System.out.println("\n\n--------------\n LIFO SPEC GENERALISED WORKLIST ALG for Dangerous variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new LIFOWorklist());
//
//          System.out.println("\n\n--------------\n FIFO SPEC GENERALISED WORKLIST ALG for Dangerous variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new FIFOWorklist());
//
//          System.out.println("\n\n--------------\n ITERATIVE REVERSE POST ORDER WORKLIST for Dangerous variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new rPWorklist());
//
//          System.out.println("\n\n--------------\n ROUND ROBIN WORKLIST for Dangerous variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationDV, new RRWorklist());

            // LIVE VARIABLES
            System.out.println("\n\n\n--------------\n Live variables \n---------------");
            AnalysisSpecificationLV analysisSpecificationLV = new AnalysisSpecificationLV(programGraph);

//          System.out.println("\n--------------\n CHAOTIC ALG for Live variables  \n---------------\n");
//          chaoticAlgorithm.execute(programGraph, analysisSpecificationLV);

            System.out.println("\n\n--------------\n CHAOTIC SPEC GENERALISED WORKLIST ALG for Live variables \n---------------\n");
            worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new ChaoticWorklist());

//          System.out.println("\n\n--------------\n LIFO SPEC GENERALISED WORKLIST ALG for Live variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new LIFOWorklist());
//
//          System.out.println("\n\n--------------\n FIFO SPEC GENERALISED WORKLIST ALG for Live variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new FIFOWorklist());
//
//
//          System.out.println("\n\n--------------\n ITERATIVE REVERSE POST ORDER WORKLIST for Live variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new rPWorklist());
//
//          System.out.println("\n\n--------------\n ROUND ROBIN WORKLIST for Live variables \n---------------\n");
//          worklistAlgorithm.execute(programGraph, analysisSpecificationLV, new RRWorklist());


        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
