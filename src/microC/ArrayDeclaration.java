package microC;

public class ArrayDeclaration extends Declaration{
    private int size;
    private String type;
    private String identifier;

    public ArrayDeclaration(int size, String type, String identifier) {
        this.size = size;
        this.type = type;
        this.identifier = identifier;
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
