package microC.Declaration;

import microC.AbstractNode;
import microC.Visitable;

public abstract class Declaration extends AbstractNode implements Visitable {
    protected String identifier;

    public Declaration(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
