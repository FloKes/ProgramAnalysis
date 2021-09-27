package microC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Declaration extends AbstractNode{

    private List<VariableDeclaration> varDecls = new ArrayList<>();
    private List<ArrayDeclaration> arrDecls = new ArrayList<>();
    private List<RecordDeclaration> recDecls = new ArrayList<>();

    public List<VariableDeclaration> getVarDecls() {
        return varDecls;
    }

    public List<ArrayDeclaration> getArrDecls() {
        return arrDecls;
    }

    public List<RecordDeclaration> getRecDecls() {
        return recDecls;
    }

    public void addVarDecl(VariableDeclaration decl){
        this.varDecls.add(decl);
    }
    public void addArrDecl(ArrayDeclaration decl){
        this.arrDecls.add(decl);
    }
    public void addRecDecl(RecordDeclaration decl){
        this.recDecls.add(decl);
    }

}
