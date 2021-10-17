package antlr;

import graphviz.DOTFileGenerator;
import microC.ASTBuilderVisitor;
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


            ProgramGraphGenerator programGraphGenerator = new ProgramGraphGenerator();
            ArrayList<ProgramGraphNode> programGraphNodes = programGraphGenerator.generateProgramGraph(prog);

            DOTFileGenerator dotFileGenerator = new DOTFileGenerator();
            dotFileGenerator.GenerateFile(programGraphNodes);

        } catch (IOException e) {
            throw e;

        }
    }
}
