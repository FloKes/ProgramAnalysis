package microC;

import java.util.ArrayList;
import java.util.List;

public class Statement extends AbstractNode{

    private List<WhileDeclaration> whileStatement = new ArrayList<>();
    private List<WriteStatement> writeStatement = new ArrayList<>();
    private List<ReadStatement> readStatement = new ArrayList<>();


    public void addWhileStatement(WhileDeclaration stat){this.whileStatement.add(stat);}
    public void addWriteStatement(WriteStatement writeStat){this.writeStatement.add(writeStat);}
    public void addReadStatement(ReadStatement readStat){this.readStatement.add(readStat);}


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
