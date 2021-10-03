package microC.Declaration;

import microC.AbstractNode;

import java.util.ArrayList;
import java.util.List;

public class Declarations extends AbstractNode {

    private List<Declaration> decls = new ArrayList<>();

    public void addDecl(Declaration decl) {
        this.decls.add(decl);
    }

    public List<Declaration> getDecls() {
        return decls;
    }

}
