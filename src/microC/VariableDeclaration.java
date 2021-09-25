package microC;

public class VariableDeclaration extends Expression {

    private String id;
    private String type; //if we want to extend types create Type class
    public int value;

    public VariableDeclaration(String id, String type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
}
