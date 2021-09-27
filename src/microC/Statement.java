package microC;

import java.util.ArrayList;
import java.util.List;

public class Statement extends AbstractNode{

    private List<IfElseNode> ifElses = new ArrayList<>();
    private List<LAssignNode> Lassigns = new ArrayList<>();

    public List<LAssignNode> getLAssigns() {
        return Lassigns;
    }

    public void AddLAssign(LAssignNode node){
        Lassigns.add(node);
    }

    public List<IfElseNode> getIfElses() {
        return ifElses;
    }

    public void AddIfElse(IfElseNode node){
        ifElses.add(node);
    }
}
