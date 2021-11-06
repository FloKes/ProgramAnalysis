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
import java.util.List;

public class ProgramGraphBuilderVisitor implements ASTBaseVisitor<Boolean> {
    private PrintVisitor printVisitor;
    ProgramGraph programGraph;
    ProgramGraphNode node;
    private ArrayList<ExpressionNode> expressionElementsList;
    private ArrayList<String> expressionOperators;
    boolean identifierVisitFlag = false;
    boolean numberVisitFlag = false;

    public ProgramGraphBuilderVisitor(ProgramGraph programGraph) {
        printVisitor = new PrintVisitor();
        expressionElementsList = new ArrayList<>();
        expressionOperators = new ArrayList<>();
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
        EdgeInformation edgeInformation = new EdgeInformation();
        VariableIdentifierExpressionNode vi = new VariableIdentifierExpressionNode(vd.getIdentifier());
        edgeInformation.setVariableModified(vi);
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        programGraph.addDeclaredObjects(vd.getIdentifier());
        return true;
    }

    @Override
    public Boolean visit(RecordDeclaration rd) {
        String s = rd.accept(printVisitor);
        EdgeInformation edgeInformation = new EdgeInformation();
        RecordIdentifierExpressionNode ri = new RecordIdentifierExpressionNode(rd.getIdentifier());
        edgeInformation.setVariableModified(ri);
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        programGraph.addDeclaredObjects(rd.getIdentifier());
        return true;
    }

    @Override
    public Boolean visit(ArrayDeclaration ad) {
        String s = ad.accept(printVisitor);
        EdgeInformation edgeInformation= new EdgeInformation();
        ArrayIdentifierExpressionNode ai = new ArrayIdentifierExpressionNode(ad.getIdentifier());
        edgeInformation.setVariableModified(ai);
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        programGraph.addDeclaredObjects(ad.getIdentifier());
        return true;
    }


    //Expressions

    @Override
    public Boolean visit(ValueExpressionNode n) {
        var left = n.getLeft();
        var right = n.getRight();
        if(left instanceof ValueExpressionNode){
            left.accept(this);
            //System.out.println("Is identifier expression node: " + ((IdentifierExpressionNode) left).getIdentifier());
        }
        if(right instanceof  ValueExpressionNode){
            right.accept(this);
            //System.out.println("Is number expression: " + ((NumberExpressionNode) left).getValue());
        }

        if(left instanceof IdentifierExpressionNode){
            identifierVisitFlag = true;
            left.accept(this);
            //System.out.println("Is identifier expression node: " + ((IdentifierExpressionNode) right).getIdentifier());
        }
        else if(left instanceof  NumberExpressionNode){
            numberVisitFlag = true;
            left.accept(this);
            //System.out.println("Is number expression: " + ((NumberExpressionNode) right).getValue());
        }

        if(right instanceof IdentifierExpressionNode){
            identifierVisitFlag = true;
            right.accept(this);
            //System.out.println("Is identifier expression node: " + ((IdentifierExpressionNode) right).getIdentifier());
        }
        else if(right instanceof  NumberExpressionNode){
            numberVisitFlag = true;
            right.accept(this);
            //System.out.println("Is number expression: " + ((NumberExpressionNode) right).getValue());
        }

        var operator = n.getOperator();
        expressionOperators.add(operator);
        return true;
    }

    @Override
    public Boolean visit(VariableIdentifierExpressionNode n) {
        System.out.println("Variable identifier accesed: " + n.getIdentifier());
        if(identifierVisitFlag){
            expressionElementsList.add(n);
        }
        return true;
    }

    @Override
    public Boolean visit(RecordIdentifierExpressionNode n) {
        return null;
    }

    @Override
    public Boolean visit(RecAccessNode n) {
        return null;
    }

    @Override
    public Boolean visit(NumberExpressionNode n) {
        System.out.println("Number expression accessed : " + n.getValue());
        if(numberVisitFlag){
            expressionElementsList.add(n);
        }
        return true;
    }

    @Override
    public Boolean visit(ArrayIdentifierExpressionNode n) {
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


    // Statements

    @Override
    public Boolean visit(LAssignNode n) {
        String s = n.accept(printVisitor);

        //TODO edge Expression LASSign
        //EdgeExpression edgeExpression = new EdgeExpression();
        EdgeInformation edgeInformation = new EdgeInformation();
        edgeInformation.setVariableModified(n.getLeft());
        var right = n.getRight();
        var rightText = right.accept(printVisitor);
        System.out.println(right.accept(printVisitor));
        right.accept(this);
        ArrayList<ExpressionNode> expressionElementsListClone = new ArrayList<>();
        for (ExpressionNode expressionNode: expressionElementsList){
            expressionElementsListClone.add(expressionNode);
        }

        edgeInformation.setEdgeExpression(new EdgeExpression(expressionElementsListClone, rightText));
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        expressionElementsList.clear();
        expressionOperators.clear();
        return true;
    }

    @Override
    public Boolean visit(RecordAssignNode n) {
        String s = n.accept(printVisitor);
        //TODO edge Expression RECASSIGN
        //EdgeExpression edgeExpression = new EdgeExpression();
        EdgeInformation edgeInformation = new EdgeInformation();
        edgeInformation.setVariableModified(n.getIdentifier());
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
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
        // TODO
        node = node.addEdgeOut(new ProgramGraphEdge(bexprString, null));
        programGraph.addNode(node);

        // Add nodes for the block statement where boolean expression is evaluated true
        block.accept(this);

        // Save node where code after the if / if else statement continues
        var nodeAfterBlock = node;

        // There are two cases, if statement and if-else statement
        node = programGraph.getProgramGraphNode(ifNodeNumber);

        if (elseNode == null){
            // Add edge from if node where boolean statement is not true
            // TODO
            node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString, null), nodeAfterBlock);
        }
        else {
            // TODO
            node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString, null));
            programGraph.addNode(node);

            elseNode.accept(this);

            // The last statement of the elseBlock needs to be joined to the end of the previous block
            // Since we are using visitor pattern that statement by default creates a new node, whereas it should join

            //Since the incorrect node can have multiple edges coming in we need to change the end for all of them
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
        var bexpr = n.getBexpr();
        var block = n.getBlock();

        // Get string for boolean expression and not boolean expression
        var bexprString = bexpr.accept(printVisitor);
        var bexprNotString = "!(" + bexprString + ")";

        // Save number of the node where the boolean statement is evaluated
        int evalNodeNumber = node.getNumber();

        // Add node after boolean expression is evaluated true
        // TODO
        node = node.addEdgeOut(new ProgramGraphEdge(bexprString, null));
        programGraph.addNode(node);

        // Add nodes for the block statement where boolean expression is evaluated true
        block.accept(this);

        // The last statement of the block needs to be joined to the node where the boolean expression is evaluated
        // Since we are using visitor pattern that statement by default creates a new node, whereas it should join

        //Since the incorrect node can have multiple edges coming in we need to change the end for all of them
        var lastNode = node;
        var evalNode = programGraph.getProgramGraphNode(evalNodeNumber);
        for (ProgramGraphEdge inGoingEdge: lastNode.getInGoing()){
            inGoingEdge.setEndNode(evalNode);
            evalNode.addEdgeIn(inGoingEdge);
        }

        // Clear up connection of the unnecessary node
        lastNode.clearAll();
        programGraph.removeProgramGraphNode(lastNode);

        // Add edge from if node where boolean statement is not true
        node = evalNode;
        // TODO
        node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString, null));
        programGraph.addNode(node);

        return true;
    }

    @Override
    public Boolean visit(ReadStatement n) {
        String s = n.accept(printVisitor);
        EdgeInformation edgeInformation= new EdgeInformation();
        edgeInformation.setVariableModified(n.getLexpr());
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        return true;
    }

    @Override
    public Boolean visit(WriteStatement n) {
        String s = n.accept(printVisitor);
        // TODO
        node = node.addEdgeOut(new ProgramGraphEdge(s, null));
        programGraph.addNode(node);

        return true;
    }
}