package microC.ProgramGraph;

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

        var bexprString = bexpr.accept(printVisitor);
        var bexprNotString = "!(" + bexprString + ")";

        int ifNodeNumber = node.getNumber();

        node = node.addEdgeOut(new ProgramGraphEdge(bexprString));
        programGraph.addNode(node);

        block.accept(this);

        var nodeAfterBlock = node;

        node = programGraph.getProgramGraphNode(ifNodeNumber);
        node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString), nodeAfterBlock);
        programGraph.addNode(node);
        return true;
    }

    @Override
    public Boolean visit(ElseNode n) {
        return null;
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