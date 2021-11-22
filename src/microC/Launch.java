package microC;

import antlr.MicroCLexer;
import antlr.MicroCParser;
import graphviz.DOTFileGenerator;
import microC.MonotoneAnalyses.Algorithms.ChaoticAlgorithm;
import microC.MonotoneAnalyses.Algorithms.ChaoticWorklistAlgorithm;
import microC.MonotoneAnalyses.Algorithms.DevelopmentAlgorithm;
import microC.MonotoneAnalyses.Algorithms.LIFOWorklistAlgorithm;
import microC.MonotoneAnalyses.DangerousVariables.AnalysisSpecificationDV;
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

//            DetectionOfSignsChaotic dsc = new DetectionOfSignsChaotic();
//            var initMem = new HashMap<String, HashSet<Character>>();
//            var xMem = new HashSet<Character>();
//            var yMem = new HashSet<Character>();
//            xMem.add('-');
//            xMem.add('0');
//            xMem.add('+');
//            yMem.add('0');
//            //x = {-,0,+}, y = {-,0,+}
//            initMem.put("x",xMem);
//            initMem.put("y", yMem);
//            dsc.run(programGraph, initMem);

            // Output program graph to .dot file
            DOTFileGenerator dotFileGenerator = new DOTFileGenerator();
            dotFileGenerator.GenerateFile(programGraphNodes);


            // Reach definitions analysis
            ReachingDefinitionsAnalysis reachingDefinitionsAnalysis = new ReachingDefinitionsAnalysis();
            reachingDefinitionsAnalysis.doAnalysis(programGraph);
//
//
//            // Live variable analysis
//            LiveVariablesAnalysis liveVariablesAnalysis = new LiveVariablesAnalysis();
//            liveVariablesAnalysis.doAnalysis(programGraph);


            ChaoticAlgorithm chaoticAlgorithm = new ChaoticAlgorithm();
            ChaoticWorklistAlgorithm chaoticWorklistAlgorithm = new ChaoticWorklistAlgorithm();
            LIFOWorklistAlgorithm lifoWorklistAlgorithm = new LIFOWorklistAlgorithm();

            System.out.println("\n\n--------------\n Reaching definition \n---------------\n");
            AnalysisSpecificationRD analysisSpecificationRD = new AnalysisSpecificationRD(programGraph);
            System.out.println("\n\n--------------\n CHAOTIC ALG FOR REACHING DEFINITIONS \n---------------\n");
            chaoticAlgorithm.execute(programGraph, analysisSpecificationRD);

            System.out.println("\n\n--------------\n CHAOTIC WORKLIST ALGORITHM REACHING DEFINITIONS \n---------------\n");
            chaoticWorklistAlgorithm.execute(programGraph, analysisSpecificationRD);


            System.out.println("\n\n--------------\n Dangerous variables \n---------------\n");
            DevelopmentAlgorithm developmentAlgorithm = new DevelopmentAlgorithm();
            AnalysisSpecificationDV analysisSpecificationDV = new AnalysisSpecificationDV(programGraph);

            System.out.println("\n\n--------------\n CHAOTIC ALG FOR Dangerous variables \n---------------\n");
            chaoticAlgorithm.execute(programGraph, analysisSpecificationDV);

            System.out.println("\n\n--------------\n CHAOTIC WORKLIST ALG FOR Dangerous variables \n---------------\n");
            chaoticWorklistAlgorithm.execute(programGraph, analysisSpecificationDV);

            System.out.println("\n\n--------------\n LIFO WORKLIST ALG FOR Dangerous variables \n---------------\n");
            lifoWorklistAlgorithm.execute(programGraph, analysisSpecificationDV);


            int i = 0;
        } catch (IOException e) {
            throw e;

        }
    }
}
