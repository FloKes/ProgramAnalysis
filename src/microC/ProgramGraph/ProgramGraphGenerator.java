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
    private ArrayList<ProgramGraphNode> programGraphNodes;
    ProgramGraphNode node;
    public ProgramGraphGenerator() {
        this.declarations = new ArrayList<>();
        this.statements = new ArrayList<>();
        programGraphNodes = new ArrayList<>();
        node = new ProgramGraphNode();
        programGraphNodes.add(node);
    }

    public ArrayList<ProgramGraphNode> generateProgramGraph(AbstractNode node){
        ProgramNode programNode = (ProgramNode) node;
        //programNode.accept(programGraphVisitor);
        declarations.addAll(programNode.getDecls());
        statements.addAll(programNode.getStatements());
        generateForDeclarations(declarations);
        generateForStatements(statements);
        return this.programGraphNodes;
    }

    private void generateForDeclarations(ArrayList<Declaration> declarations){
        for (Declaration declaration: declarations){
            String s = declaration.accept(programGraphVisitor);
            node = node.addEdgeOut(new ProgramGraphEdge(s));
            programGraphNodes.add(node);
            System.out.println(s);
        }
    }

    private void generateForStatements(ArrayList<Statement> statements){
        for (Statement statement: statements){
            String s = statement.accept(programGraphVisitor);
            node = node.addEdgeOut(new ProgramGraphEdge(s));
            programGraphNodes.add(node);
            System.out.println(s);
        }
    }
}
