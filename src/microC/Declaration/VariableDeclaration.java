package microC.Declaration;

import microC.ASTBaseVisitor;

public class VariableDeclaration extends Declaration {

    private String type; //if we want to extend types create Type class
    private int initVal;

    public VariableDeclaration(String identifier, String type) {
        super(identifier);
        this.type = type;
    }

    public VariableDeclaration(String identifier, String type, int initVal) {
        super(identifier);
        this.type = type;
        this.initVal = initVal;
    }

    public int getInitVal() {
        return initVal;
    }

    public void setInitVal(int initVal) {
        this.initVal = initVal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
