package microC;

import antlr.MicroCBaseVisitor;
import antlr.MicroCParser;

public class AntlrToProgram extends MicroCBaseVisitor<Program> {

    @Override
    public Program visitProgram(MicroCParser.ProgramContext ctx) {
        Program prog = new Program();

        return prog;
    }
}
