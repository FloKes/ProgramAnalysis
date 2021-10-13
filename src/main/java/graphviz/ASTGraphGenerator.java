//C:\Users\giaco\IdeaProjects\Program-Analysis\src\graphviz>dot -Tpng input.dot > output.png

//dot -Tpng input.dot -o output.png
//https://github.com/nidi3/graphviz-java
package graphviz;

import microC.AbstractNode;
import microC.Declaration.Declaration;
import microC.ProgramNode;
import microC.Statement.Statement;

import java.util.ArrayList;
import java.util.List;


public class ASTGraphGenerator{
    private ASTGraphVisitor visitor = new ASTGraphVisitor();
    private ArrayList<String> graphElements = new ArrayList<>();
    private String graph = "";
    private DOTFileGenerator generator = new DOTFileGenerator();


    public void generateASTDot(AbstractNode node){
        ProgramNode programNode = (ProgramNode) node;
        var declarations = programNode.getDecls();
        var statements = programNode.getStatements();
        generateForDeclarations(declarations);
        generateForStatements(statements);

        for (String element: graphElements){
            System.out.println(element);
        }
        //generator.GenerateFile(graphElements.toArray(new String[0]));
    }

    private void generateForDeclarations(List<Declaration> decls){
        ArrayList<Declaration> declarations = new ArrayList<>();
        ArrayList<String> elements = new ArrayList<>();
        for (Declaration decl : decls){
            declarations.add(decl);
        }
        for (Declaration declaration: declarations){
            //System.out.println(declaration.accept(visitor));
            elements.add(declaration.accept(visitor));
        }
        graphElements.addAll(elements);
    }

    private void generateForStatements(List<Statement> statements){
        ArrayList<String> elements = new ArrayList<>();
        for (Statement statement : statements){
            //System.out.println(statement.accept(visitor));
            elements.add(statement.accept(visitor));
        }
        graphElements.addAll(elements);
    }
}