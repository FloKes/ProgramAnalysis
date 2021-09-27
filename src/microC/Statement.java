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

}
