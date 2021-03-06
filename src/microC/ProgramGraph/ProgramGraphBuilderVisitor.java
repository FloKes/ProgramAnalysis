package microC.ProgramGraph;

// MUCHO IMPORTANTE
// If you create a new node and don't add it to the program graph it won't have a reference to the program graph,
// And therefore won't be able to create outgoing edges and nodes as it can't check if the new number of the node
// is already in the program graph

import com.kitfox.svg.A;
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
    private ArrayList<ExpressionNode> expressionElementsList;
    private ArrayList<ExpressionNode> arrayIdentifierElementListTotal;
    private ArrayList<ExpressionNode> arrayIdentifierElementList;
    private ArrayList<String> expressionOperators;
    private ArrayList<String> arrayIndexExpressionElements;
    boolean identifierVisitFlag = false;
    boolean arrayIndexVisitFlag = false;
    boolean nestedArrayIndexFlag = false;
    boolean arrayIdentifierVisitFlag = false;
    boolean numberVisitFlag = false;

    public ProgramGraphBuilderVisitor(ProgramGraph programGraph) {
        printVisitor = new PrintVisitor();
        expressionElementsList = new ArrayList<>();
        arrayIdentifierElementListTotal = new ArrayList<>();
        arrayIdentifierElementList = new ArrayList<>();
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
        edgeInformation.setDefined(vi);
        edgeInformation.setDeclared(vi);
        edgeInformation.setDeclarationNode(vd);
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
        edgeInformation.setDefined(ri);
        edgeInformation.setDeclared(ri);
        edgeInformation.setDeclarationNode(rd);
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
        edgeInformation.setDefined(ai);
        edgeInformation.setDeclared(ai);
        edgeInformation.setDeclarationNode(ad);
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        programGraph.addDeclaredObjects(ad.getIdentifier());
        return true;
    }


    //Expressions

    @Override
    public Boolean visit(VariableIdentifierExpressionNode n) {
        if(identifierVisitFlag && !arrayIndexVisitFlag){
            expressionElementsList.add(n);
            identifierVisitFlag = false;
        }
        else if (arrayIndexVisitFlag)
        {
            arrayIdentifierElementList.add(n);
        }
        return true;
    }

    @Override
    public Boolean visit(ArrayIdentifierExpressionNode n) {
        if (arrayIndexVisitFlag && nestedArrayIndexFlag)
        {
            var indexExpression = n.getIndexExpression();
            arrayIndexVisitFlag = true;
            nestedArrayIndexFlag = true;
            indexExpression.accept(this);
            arrayIndexVisitFlag = false;
            arrayIdentifierVisitFlag = false;
        }
        else if(arrayIdentifierVisitFlag){
            var indexExpression = n.getIndexExpression();
            arrayIndexVisitFlag = true;
            nestedArrayIndexFlag = true;
            indexExpression.accept(this);
            nestedArrayIndexFlag = false;
            arrayIndexVisitFlag = false;
            arrayIdentifierVisitFlag = false;
        }
        return true;
    }

    @Override
    public Boolean visit(RecordIdentifierExpressionNode n) {
        if(identifierVisitFlag && !arrayIndexVisitFlag){
            expressionElementsList.add(n);
            identifierVisitFlag = false;
        }
        else if (arrayIndexVisitFlag)
        {
            arrayIdentifierElementList.add(n);
        }
        return true;
    }

    @Override
    public Boolean visit(RecAccessNode n) {
        return null;
    }

    @Override
    public Boolean visit(NumberExpressionNode n) {
        if(numberVisitFlag  && !arrayIndexVisitFlag){
            expressionElementsList.add(n);
            numberVisitFlag = false;
        }
        else if (arrayIndexVisitFlag)
        {
            arrayIdentifierElementList.add(n);
        }
        return true;
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
        System.out.println("OpB");
        return true;
    }

    @Override
    public Boolean visit(BooleanOpRBooleanNode n) {
        var left = n.getLeft();
        var right = n.getRight();

        if(left instanceof ValueExpressionNode){
            left.accept(this);
            //System.out.println("Is identifier expression node: " + ((IdentifierExpressionNode) left).getIdentifier());
        }
        else if(right instanceof  ValueExpressionNode){
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
            if (left instanceof ArrayIdentifierExpressionNode){
                arrayIdentifierVisitFlag = true;
                left.accept(this);
                for (ExpressionNode expressionNode: arrayIdentifierElementList){
                    arrayIdentifierElementListTotal.add(expressionNode);
                }
                arrayIdentifierElementList.clear();
            }
            else {
                identifierVisitFlag = true;
                left.accept(this);
            }
        }
        else if(left instanceof  NumberExpressionNode){
            numberVisitFlag = true;
            left.accept(this);
            //System.out.println("Is number expression: " + ((NumberExpressionNode) right).getValue());
        }

        if(right instanceof IdentifierExpressionNode){
            if (right instanceof ArrayIdentifierExpressionNode){
                arrayIdentifierVisitFlag = true;
                right.accept(this);
                for (ExpressionNode expressionNode: arrayIdentifierElementList){
                    arrayIdentifierElementListTotal.add(expressionNode);
                }
                arrayIdentifierElementList.clear();
            }
            else {
                identifierVisitFlag = true;
                right.accept(this);
            }
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


    // Statements

    @Override
    public Boolean visit(LAssignNode n) {
        String s = n.accept(printVisitor);

        EdgeInformation edgeInformation = new EdgeInformation();
        var left = n.getLeft();
        if (left instanceof ArrayIdentifierExpressionNode){
            arrayIdentifierVisitFlag = true;
            left.accept(this);
            for (ExpressionNode expressionNode: arrayIdentifierElementList){
                ((ArrayIdentifierExpressionNode) left).addindexExpressionElements(expressionNode);
                arrayIdentifierElementListTotal.add(expressionNode);
            }
            arrayIdentifierElementList.clear();
        }
        edgeInformation.setDefined(left);

        var right = n.getRight();
        var rightText = right.accept(printVisitor);
        System.out.println(right.accept(printVisitor));
        if(right instanceof ValueExpressionNode){
            right.accept(this);
        }
        else if(right instanceof IdentifierExpressionNode){
            if (right instanceof ArrayIdentifierExpressionNode){
                arrayIdentifierVisitFlag = true;
                right.accept(this);
                for (ExpressionNode expressionNode: arrayIdentifierElementList){
                    arrayIdentifierElementListTotal.add(expressionNode);
                }
                arrayIdentifierElementList.clear();
            }
            else {
                identifierVisitFlag = true;
                right.accept(this);
            }
        }
        else if(right instanceof NumberExpressionNode){
            numberVisitFlag = true;
            right.accept(this);
        }
        ArrayList<ExpressionNode> expressionElementsListClone = new ArrayList<>();
        String expressionElementsString = "";
        for (ExpressionNode expressionNode: expressionElementsList){
            expressionElementsListClone.add(expressionNode);
            expressionElementsString += expressionNode.accept(printVisitor) + "; ";
        }
        edgeInformation.setEdgeExpression(new EdgeExpression(expressionElementsListClone, rightText));

        ArrayList<ExpressionNode> arrayIdentifierElementListTotalClone = new ArrayList<>();
        for (ExpressionNode expressionNode: arrayIdentifierElementListTotal){
            arrayIdentifierElementListTotalClone.add(expressionNode);
        }
        edgeInformation.getEdgeExpression().setArrayIndexObjectsUsed(arrayIdentifierElementListTotalClone);
        edgeInformation.setExpressionNode(n.getRight());
        System.out.println(expressionElementsString +"\n");
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        expressionElementsList.clear();
        arrayIdentifierElementListTotal.clear();
        expressionOperators.clear();
        return true;
    }

    @Override
    public Boolean visit(RecordAssignNode n) {
        String s = n.accept(printVisitor);
        //TODO edge Expression RECASSIGN
        //EdgeExpression edgeExpression = new EdgeExpression();
        EdgeInformation edgeInformation = new EdgeInformation();
        edgeInformation.setDefined(n.getIdentifier());
        var fst = n.getFst();
        var snd = n.getSnd();

        if(fst instanceof ValueExpressionNode){
            fst.accept(this);
        }
        else if(fst instanceof IdentifierExpressionNode){
            if (fst instanceof ArrayIdentifierExpressionNode){
                arrayIdentifierVisitFlag = true;
                fst.accept(this);
                for (ExpressionNode expressionNode: arrayIdentifierElementList){
                    arrayIdentifierElementListTotal.add(expressionNode);
                }
                arrayIdentifierElementList.clear();
            }
            else {
                identifierVisitFlag = true;
                fst.accept(this);
            }
        }
        else if(fst instanceof NumberExpressionNode){
            numberVisitFlag = true;
            fst.accept(this);
        }

        if(snd instanceof ValueExpressionNode){
            snd.accept(this);
        }
        else if(snd instanceof IdentifierExpressionNode){
            if (snd instanceof ArrayIdentifierExpressionNode){
                arrayIdentifierVisitFlag = true;
                snd.accept(this);
                for (ExpressionNode expressionNode: arrayIdentifierElementList){
                    arrayIdentifierElementListTotal.add(expressionNode);
                }
                arrayIdentifierElementList.clear();
            }
            else {
                identifierVisitFlag = true;
                snd.accept(this);
            }
        }
        else if(snd instanceof NumberExpressionNode){
            numberVisitFlag = true;
            snd.accept(this);
        }

        ArrayList<ExpressionNode> expressionElementsListClone = new ArrayList<>();
        String expressionElementsString = "";
        for (ExpressionNode expressionNode: expressionElementsList){
            expressionElementsListClone.add(expressionNode);
            expressionElementsString += expressionNode.accept(printVisitor) + "; ";
        }

        ArrayList<ExpressionNode> arrayIdentifierElementListTotalClone = new ArrayList<>();
        for (ExpressionNode expressionNode: arrayIdentifierElementListTotal){
            arrayIdentifierElementListTotalClone.add(expressionNode);
        }

        edgeInformation.setEdgeExpression(new EdgeExpression(expressionElementsListClone, "()"));
        edgeInformation.getEdgeExpression().setArrayIndexObjectsUsed(arrayIdentifierElementListTotalClone);
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);

        expressionElementsList.clear();
        arrayIdentifierElementListTotal.clear();
        arrayIdentifierElementListTotal.clear();
        expressionOperators.clear();

        return true;
    }

    @Override
    public Boolean visit(IfElseNode n) {
        var bexpr = n.getBexpr();
        var block = n.getBlock();
        var elseNode = n.getElseNode();

        // Visit the boolean expression to get the variables used
        bexpr.accept(this);
        // Get string for boolean expression and not boolean expression
        var bexprString = bexpr.accept(printVisitor);
        var bexprNotString = "!(" + bexprString + ")";

        // Save number of the node where the if statement is evaluated
        int ifNodeNumber = node.getNumber();

        // Add node after boolean expression is evaluated true
        // TODO
        ArrayList<ExpressionNode> expressionElementsListClone = new ArrayList<>();
        String expressionElementsString = "";
        for (ExpressionNode expressionNode: expressionElementsList){
            expressionElementsListClone.add(expressionNode);
            expressionElementsString += expressionNode.accept(printVisitor) + "; ";
        }

        EdgeInformation edgeInformation = new EdgeInformation();
        edgeInformation.setBooleanExpressionNode(bexpr);
        edgeInformation.setEdgeExpression(new EdgeExpression(expressionElementsListClone, bexprString));
        System.out.println(expressionElementsString +"\n");
        expressionElementsList.clear();
        expressionOperators.clear();

        node = node.addEdgeOut(new ProgramGraphEdge(bexprString, edgeInformation));
        programGraph.addNode(node);

        // Add nodes for the block statement where boolean expression is evaluated true
        block.accept(this);

        // Save node where code after the if / if else statement continues
        var nodeAfterBlock = node;

        // There are two cases, if statement and if-else statement
        node = programGraph.getProgramGraphNode(ifNodeNumber);

        EdgeInformation edgeInformationNot = new EdgeInformation();
        edgeInformation.setBooleanExpressionNode(bexpr);
        edgeInformation.setNot(true);
        edgeInformationNot.setEdgeExpression(new EdgeExpression(expressionElementsListClone, bexprNotString));
        System.out.println(expressionElementsString +"\n");

        if (elseNode == null){
            // Add edge from if node where boolean statement is not true
            // TODO
            node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString, edgeInformationNot), nodeAfterBlock);
        }
        else {
            // TODO
            node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString, edgeInformationNot));
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

        // Visit the boolean expression to get the variables used
        bexpr.accept(this);
        // Get string for boolean expression and not boolean expression
        var bexprString = bexpr.accept(printVisitor);
        var bexprNotString = "!(" + bexprString + ")";

        // Save number of the node where the boolean statement is evaluated
        int evalNodeNumber = node.getNumber();

        // Add node after boolean expression is evaluated true
        // TODO
        ArrayList<ExpressionNode> expressionElementsListClone = new ArrayList<>();
        String expressionElementsString = "";
        for (ExpressionNode expressionNode: expressionElementsList){
            expressionElementsListClone.add(expressionNode);
            expressionElementsString += expressionNode.accept(printVisitor) + "; ";
        }


        EdgeInformation edgeInformation = new EdgeInformation();
        edgeInformation.setBooleanExpressionNode(bexpr);
        edgeInformation.setEdgeExpression(new EdgeExpression(expressionElementsListClone, bexprString));
        System.out.println(expressionElementsString +"\n");
        expressionElementsList.clear();
        expressionOperators.clear();

        node = node.addEdgeOut(new ProgramGraphEdge(bexprString, edgeInformation));
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
        EdgeInformation edgeInformationNot = new EdgeInformation();
        edgeInformationNot.setBooleanExpressionNode(bexpr);
        edgeInformationNot.setNot(true);
        edgeInformationNot.setEdgeExpression(new EdgeExpression(expressionElementsListClone, bexprNotString));
        node = node.addEdgeOut(new ProgramGraphEdge(bexprNotString, edgeInformationNot));
        programGraph.addNode(node);

        return true;
    }

    @Override
    public Boolean visit(ReadStatement n) {
        String s = n.accept(printVisitor);
        EdgeInformation edgeInformation= new EdgeInformation();
        edgeInformation.setDefined(n.getLexpr());
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        return true;
    }

    @Override
    public Boolean visit(WriteStatement n) {
        String s = n.accept(printVisitor);

        EdgeInformation edgeInformation = new EdgeInformation();
        var right = n.getExpressionNode();
        var rightText = right.accept(printVisitor);
        if(right instanceof ValueExpressionNode){
            right.accept(this);
        }
        else if(right instanceof IdentifierExpressionNode){
            identifierVisitFlag = true;
            right.accept(this);
        }
        else if(right instanceof NumberExpressionNode){
            numberVisitFlag = true;
            right.accept(this);
        }
        ArrayList<ExpressionNode> expressionElementsListClone = new ArrayList<>();
        String expressionElementsString = "";
        for (ExpressionNode expressionNode: expressionElementsList){
            expressionElementsListClone.add(expressionNode);
            expressionElementsString += expressionNode.accept(printVisitor) + "; ";
        }
        edgeInformation.setEdgeExpression(new EdgeExpression(expressionElementsListClone, rightText));
        System.out.println(expressionElementsString +"\n");
        node = node.addEdgeOut(new ProgramGraphEdge(s, edgeInformation));
        programGraph.addNode(node);
        expressionElementsList.clear();
        expressionOperators.clear();
        return true;
    }
}