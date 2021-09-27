package microC;

import java.util.ArrayList;
import java.util.List;

public class WhileDeclaration extends AbstractNode {

    private Bexpression bExpr;
    private BlockNode blockStatement;

    public WhileDeclaration(Bexpression bExpr, BlockNode blockStatement) {
        this.bExpr = bExpr;
        this.blockStatement = blockStatement;
    }

}
