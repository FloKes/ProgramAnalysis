package microC;

import java.util.ArrayList;
import java.util.List;

public class WhileDeclaration extends AbstractNode {

    private Bexpression bExpr;
    private BlockStatement blockStatement;

    public WhileDeclaration(Bexpression bExpr, BlockStatement blockStatement) {
        this.bExpr = bExpr;
        this.blockStatement = blockStatement;
    }

}
