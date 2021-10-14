package microC.ProgramGraph;

// MUCHO IMPORTANTE
// If you create a new node and don't add it to the program graph it won't have a reference to the program graph,
// And therefore won't be able to create outgoing edges and nodes as it can't check if the new number of the node
// is already in the program graph

import microC.ASTBaseVisitor;
import microC.Declaration.ArrayDeclaration;
import microC.Declaration.Declaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.PrintVisitor;
import microC.ProgramNode;
import microC.Statement.*;

import java.util.ArrayList;

public class ProgramGraphBuilderVisitor implements ASTBaseVisitor<Boolean> {
    private PrintVisitor printVisitor;
    ProgramGraph programGraph;
    ProgramGraphNode node;

    public ProgramGraphBuilderVisitor(ProgramGraph programGraph) {
        printVisitor = new PrintVisitor();
        this.programGraph = programGraph;
    }

    @Override
    public Boolean visit(ProgramNode prog) {
        node = new ProgramGraphNode();
        programGraph.addNode(node);

        //Update program graph for declarations
        ArrayList<Declaration> declarations= new ArrayList<>();
        declarations.addAll(prog.getDecls());
        for (Declaration declaration: declarations){
            declaration.accept(this);
        }

        //Update program graph for statements
        ArrayList<Statement> statements = new ArrayList<>();
        statements.addAll(prog.getStatements());
        for (Statement statement: statements){
            statement.accept(this);
        }

        return true;
    }

    @Override
    public Boolean visit(BlockNode bstmnt) {
        ArrayList<Statement> statements = new ArrayList<>();
        statements.addAll(bstmnt.getStatements());
        for (Statement statement: statements){
            statement.accept(this);
        }

        return true;
    }


    // Declarations

    @Override
    public Boolean visit(VariableDeclaration vd) {
        String s = vd.accept(printVisitor);
        node = node.addEdgeOut(new ProgramGraphEdge(s));
        programGraph.addNode(node);
        return true;
    }

    @Override
    public Boolean visit(RecordDeclaration rd) {
        return null;
    }

    @Override
    public Boolean visit(ArrayDeclaration ad) {
        return null;
    }


    //Expressions

    @Override
    public Boolean visit(VariableIdentifierNode n) {
        return null;
    }

    @Override
    public Boolean visit(NumberExpressionNode n) {
        return null;
    }

    @Override
    public Boolean visit(ArrayIdentifierExpression n) {
        return null;
    }


    @Override
    public Boolean visit(BooleanValueExpressionNode n) {
        return null;
    }

    @Override
    public Boolean visit(NegationBooleanExprNode n) {
        return null;
    }

    @Override
    public Boolean visit(BooleanOpBBooleanNode n) {
        return null;
    }

    @Override
    public Boolean visit(BooleanOpRBooleanNode n) {
        return null;
    }

    @Override
    public Boolean visit(RecAccessNode n) {
        return null;
    }

    // Statements

    @Override
    public Boolean visit(LAssignNode n) {
        String s = n.accept(printVisitor);
        node = node.addEdgeOut(new ProgramGraphEdge(s));
        programGraph.addNode(node);

        return true;
    }

    @Override
    public Boolean visit(IfElseNode n) {
        var bexpr = n.getBexpr();
        var block = n.getBlock();
        var elseNode = n.getElseNode();

        // Get string for boolean expression and not boolean expression
        var bexprString = bexpr.accept(printVisitor);
        var bexprNotString = "!(" + bexprString + ")";

        // Save number of the node where the if statement is evaluated
        int ifNodeNumber = node.getNumber();

        // Add node after boolean expression is evaluated true
        node = node.addEdgeOut(new ProgramGraphEdge(bexprString));
        programGraph.addNode(node);

        // Add nodes for the block statement where boolean expression is evaluated true
        block.accept(this);

        // Save node where code after the if / if else statement continues
        var nodeAfterBlock = node;

        // Add edge from if node where boolean statement is not true
        // There are two cases, if statement and if-else statement
        node = programGraph.getProgramGraphNode(ifNodeNumber);

        if (elseNode == null){
            node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString), nodeAfterBlock);
        }
        else {
            node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString));
            programGraph.addNode(node);

            elseNode.accept(this);

            // The last statement of the elseBlock needs to be joined to the end of the previous block
            // Since we are using visitor pattern that statement by default creates a new node, whereas it should join

            //TODO Cover this case: last node that needs to be replaced has multiple edges
            var lastNode = node;
            for (ProgramGraphEdge inGoingEdge: lastNode.getInGoing()){
                inGoingEdge.setEndNode(nodeAfterBlock);
                nodeAfterBlock.addEdgeIn(inGoingEdge);
            }

            node = nodeAfterBlock;

            // Clear up connection of the unnecessary node
            lastNode.clearAll();
            programGraph.removeProgramGraphNode(lastNode);
        }

        return true;
    }

    @Override
    public Boolean visit(ElseNode n) {
        n.getBlock().accept(this);
        return true;
    }

    @Override
    public Boolean visit(WhileDeclaration n) {
        return null;
    }

    @Override
    public Boolean visit(ReadStatement n) {
        return null;
    }

    @Override
    public Boolean visit(WriteStatement n) {
        return null;
    }
}