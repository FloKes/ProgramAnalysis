package microC.Expressions;

import microC.ASTBaseVisitor;

import java.awt.desktop.AboutEvent;
import java.util.HashSet;

public class ArrayIdentifierExpressionNode extends IdentifierExpressionNode {
    private Integer index;
    private ExpressionNode indexExpression;
    private HashSet<ExpressionNode> indexExpressionElements;

    public ArrayIdentifierExpressionNode(String identifier, int index) {
        super(identifier);
        this.index = index;
        indexExpressionElements = new HashSet<>();
    }

    public ArrayIdentifierExpressionNode(String identifier, ExpressionNode indexIdentifier) {
        super(identifier);
        this.indexExpression = indexIdentifier;
        indexExpressionElements = new HashSet<>();
    }

    public ArrayIdentifierExpressionNode(String identifier){
        super(identifier);
    }

    public Integer getIndex() {
        return index;
    }

    public ExpressionNode getIndexExpression() {
        return indexExpression;
    }

    public void addindexExpressionElements(ExpressionNode s){
        indexExpressionElements.add(s);
    }

    public HashSet<ExpressionNode> getIndexExpressionElements() {
        return indexExpressionElements;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}


