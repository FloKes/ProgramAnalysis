package microC;

import antlr.MicroCBaseVisitor;
import antlr.MicroCParser;

public class AntlrToProgram extends MicroCBaseVisitor<Program> {

    @Override
    public Program visitProgram(MicroCParser.ProgramContext ctx) {
        Program prog = new Program();

        for(int i = 0; i < ctx.getChildCount(); i++) {
            if(i == ctx.getChildCount() - 1) { //last child is EOF. Do not visit this child

            } else {
                prog.addExpression((Rexpression) ctx.getChild(i)); //TODO: we need a class which is more general. Expression class
            }
        }
        return prog;
    }
}
