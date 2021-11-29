package microC.Declaration;

import microC.ASTBaseVisitor;

public class ArrayDeclaration extends Declaration {
    private int size;
    private String type;

    public ArrayDeclaration(int size, String type, String identifier) {
        super(identifier);
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
