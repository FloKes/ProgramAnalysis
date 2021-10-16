package microC.Statement;

import microC.ASTBaseVisitor;
import microC.Expressions.BooleanExpressionNode;

public class WhileDeclaration extends Statement {

    private BooleanExpressionNode bExpr;
    private BlockNode blockStatement;

    public WhileDeclaration(BooleanExpressionNode bExpr, BlockNode blockStatement) {
        this.bExpr = bExpr;
        this.blockStatement = blockStatement;
    }

    public BooleanExpressionNode getBexpr() {
        return bExpr;
    }

    public BlockNode getBlock() {
        return blockStatement;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
