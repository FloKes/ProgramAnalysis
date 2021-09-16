import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


//based on tutorial: https://www.youtube.com/watch?v=dPWWcH5uM0g


public class Launch {

    public static void main(String[] arg) {
        try {
            String source = "micro_c.txt";
            Char Stream cs = fromFileName(source);
            gLexer lexer = new gLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            gParser parser = new gParser(token);
            ParseTree tree = parser.program();

            MyVisitor visitor = new MyVisitor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
