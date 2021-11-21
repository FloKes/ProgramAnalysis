package microC;

import antlr.MicroCLexer;
import antlr.MicroCParser;
import graphviz.DOTFileGenerator;
import microC.BitVectorAnalysis.ReachingDefinitions.Monotone.ChaoticAlgorithm;
import microC.BitVectorAnalysis.ReachingDefinitions.Monotone.AnalysisSpecificationRD;
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


//            // Reach definitions analysis
//            ReachingDefinitionsAnalysis reachingDefinitionsAnalysis = new ReachingDefinitionsAnalysis();
//            reachingDefinitionsAnalysis.doAnalysis(programGraph);
//
//
//            // Live variable analysis
//            LiveVariablesAnalysis liveVariablesAnalysis = new LiveVariablesAnalysis();
//            liveVariablesAnalysis.doAnalysis(programGraph);

            ChaoticAlgorithm chaoticAlgorithm = new ChaoticAlgorithm();
            AnalysisSpecificationRD analysisSpecificationRD = new AnalysisSpecificationRD(programGraph);
            chaoticAlgorithm.execute(programGraph, analysisSpecificationRD);

            int i = 0;
        } catch (IOException e) {
            throw e;

        }
    }
}
