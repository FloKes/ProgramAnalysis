package microC.ProgramGraph;

import microC.AbstractNode;
import microC.Declaration.Declaration;
import microC.PrintVisitor;
import microC.ProgramNode;
import microC.Statement.Statement;

import java.util.ArrayList;

public class ProgramGraphGenerator {
    private PrintVisitor printVisitor = new PrintVisitor();
    private ProgramGraphBuilderVisitor programGraphBuilderVisitor;
    private ProgramGraph programGraph;

    public ProgramGraphGenerator() {
        programGraph = new ProgramGraph();
        programGraphBuilderVisitor = new ProgramGraphBuilderVisitor(programGraph);
    }

    public ProgramGraph generateProgramGraph(AbstractNode node){
        ProgramNode programNodeAST = (ProgramNode) node;
        programGraphBuilderVisitor.visit(programNodeAST);

        return programGraph;
    }
}
