package microC.ProgramGraph;

import microC.AbstractNode;
import microC.Declaration.Declaration;
import microC.ProgramNode;
import microC.Statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class ProgramGraphGenerator {
    private ProgramGraphBuilderVisitor programGraphVisitor = new ProgramGraphBuilderVisitor();
    private ArrayList<Declaration> declarations;
    private ArrayList<Statement> statements;

    public ProgramGraphGenerator() {
        this.declarations = new ArrayList<>();
        this.statements = new ArrayList<>();
    }

    public void generateProgramGraph(AbstractNode node){
        ProgramNode programNode = (ProgramNode) node;
        //programNode.accept(programGraphVisitor);
        declarations.addAll(programNode.getDecls());
        statements.addAll(programNode.getStatements());
        generateForDeclarations(declarations);
        generateForStatements(statements);
    }

    private void generateForDeclarations(ArrayList<Declaration> declarations){
        ProgramGraphNode node = new ProgramGraphNode();
        for (Declaration declaration: declarations){
            String s = declaration.accept(programGraphVisitor);
            node = node.addEdgeOut(new ProgramGraphEdge(s));

            System.out.println(s);
        }
        System.out.println("Endinho");
    }

    private void generateForStatements(List<Statement> statements){
//        ArrayList<String> elements = new ArrayList<>();
//        for (Statement statement : statements){
//            //System.out.println(statement.accept(visitor));
//            elements.add(statement.accept(visitor));
//        }
//        graphElements.addAll(elements);
    }
}
