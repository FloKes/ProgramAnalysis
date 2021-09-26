package microC;

public class VariableDeclaration extends Declaration {

    private String identifier;
    private String type; //if we want to extend types create Type class


    public VariableDeclaration(String identifier, String type) {
        this.identifier = identifier;
        this.type = type;
    }
}
