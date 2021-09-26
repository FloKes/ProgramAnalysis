package microC;

import antlr.MicroCBaseVisitor;
import antlr.MicroCParser;

import java.util.List;

public class AntlrToRexpr extends MicroCBaseVisitor <Rexpression> {


    @Override
    public Rexpression visitRexpr(MicroCParser.RexprContext ctx) {

        String numText = ctx.getChild(0).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
}



