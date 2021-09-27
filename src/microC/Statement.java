package microC;

import java.util.ArrayList;
import java.util.List;

public class Statement extends AbstractNode{

    private List<Statement> whileStatement = new ArrayList<>();
    private List<Statement> writeStatement = new ArrayList<>();
    private List<Statement> readStatement = new ArrayList<>();


    public void addWhileStatement(Statement stat){this.whileStatement.add(stat);}
    public void addWriteStatement(Statement writeStat){this.writeStatement.add(writeStat);}
    public void addReadStatement(Statement readStat){this.readStatement.add(readStat);}


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
