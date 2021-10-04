package antlr;

import microC.ASTBuilderVisitor;
import microC.PrintVisitor;
import microC.ProgramGraph.EdgeInformation;
import microC.ProgramGraph.ProgramGraphBuilderVisitor;
import microC.ProgramNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;


//based on tutorial: https://www.youtube.com/watch?v=dPWWcH5uM0g


public class Launch {

    public static void main(String[] arg) throws IOException {
        try {
            String source = "micro_c.txt";
            CharStream cs = CharStreams.fromFileName(source);
            MicroCLexer lexer = new MicroCLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            MicroCParser parser = new MicroCParser(token);
            ParseTree tree = parser.program();

            ASTBuilderVisitor visitor = new ASTBuilderVisitor();
            var prog = visitor.visit(tree);
            ProgramGraphBuilderVisitor pg = new ProgramGraphBuilderVisitor();
            var n = pg.visit((ProgramNode) prog);
            int i = 0;
        } catch (IOException e) {
            throw e;

        }
    }
}
