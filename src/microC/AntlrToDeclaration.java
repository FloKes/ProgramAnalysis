package microC;

import antlr.MicroCBaseVisitor;
import antlr.MicroCParser;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class AntlrToDeclaration extends MicroCBaseVisitor<Declaration> {

    private List<String> vars; //stores variables declared in the program

    /* semantic errors:
    1) if the variable has been declared already
    2) variable that has not been declared
    */
    private List<String> semanticErrors;

    @Override
    public Declaration visitDecl(MicroCParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public Declaration visitVarDecl(MicroCParser.VarDeclContext ctx) {

        String type = ctx.getChild(0).getText(); //get Type
        String identifier = ctx.getChild(1).getText(); //get variable name
        return new VariableDeclaration(identifier, type);
        /* Semantic errors
        Token idToken = ctx.IDENTIFIER().getSymbol();
        int line = idToken.getLine(); //tells you line errors is at
        int column = idToken.getCharPositionInLine() + 1; //tells you position of where error is

        String id = ctx.getChild(1).getText();
        if (vars.contains(id)) {
            semanticErrors.add("Error: variable" + id + "already declared (" + line + ", " + column + ")");
        }
        else {
            vars.add(id);
        } */
    }

    @Override
    public Declaration visitArrayDecl(MicroCParser.ArrayDeclContext ctx) {
        return super.visitArrayDecl(ctx);
    }

    @Override
    public Declaration visitRecordDecl(MicroCParser.RecordDeclContext ctx) {
        return super.visitRecordDecl(ctx);
    }
}
