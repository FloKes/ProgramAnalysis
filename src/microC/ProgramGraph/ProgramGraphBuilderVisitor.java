package microC.ProgramGraph;

import microC.ASTBaseVisitor;
import microC.Declaration.ArrayDeclaration;
import microC.Declaration.RecordDeclaration;
import microC.Declaration.VariableDeclaration;
import microC.Expressions.*;
import microC.ProgramNode;
import microC.Statement.*;

public class ProgramGraphBuilderVisitor implements ASTBaseVisitor<Node> {
    private int nodeNum = 0;
    private void addEdge(Node from, Node to) {
        Edge edge = new Edge(from.getEdgeInfo(), from, to);
        from.setTo(edge);
        to.setFrom(edge);
    }

    @Override
    public Node visit(ProgramNode prog) {
        Node start = null;
        Node last = null;
        //Declarations
        for (var n : prog.getDecls()) {
            var node = n.accept(this);
            if(start == null) {
                start = node;
            }
            if(last != null) {
                this.addEdge(last, node);
            }
            last = node;
        }

        //Statements
        for (var n : prog.getStatements()) {
            var node = n.accept(this);
            //todo fix duplicate
            if(last != null && node.getTo() == null) {
                this.addEdge(last, node);
            }
            //handle if else
            if(node.getTo() != null && node.getAlternativeTo() != null) {
                last = getLast(node);
            } else{
                last = node;
            }
        }
        return start;
    }

    @Override
    public Node visit(BlockNode bstmnt) {
        Node start = null;
        Node last = null;
        for (var n : bstmnt.getStatements()) {
            var node = n.accept(this);
            if(start == null){
                start = node;
            }
            //todo fix duplicate
            if(last != null && node.getTo() == null) {
                this.addEdge(last, node);
            }
            //handle if else
            if(node.getTo() != null && node.getAlternativeTo() != null) {
                last = getLast(node);
            }else {
                last = node;
            }
        }
        return start;
    }

    @Override
    public Node visit(RecordDeclaration rd) {
        var sb = new StringBuilder();
        var fst = rd.getFirst();
        var snd = rd.getSecond();
        sb.append(rd.getIdentifier()).append("(").append(fst.getIdentifier()).append(", ").append(snd.getIdentifier()).append(") = ");
        sb.append("(").append(fst.getInitVal()).append(", ").append(snd.getInitVal()).append(")");
        return new Node("p" + this.nodeNum++, new AssignmentEdgeInfo(sb.toString(), rd.getIdentifier()));
    }

    @Override
    public Node visit(VariableDeclaration vd) {
        var sb = new StringBuilder();
        sb.append(vd.getIdentifier()).append(":=").append(vd.getInitVal());
        return new Node("p" + this.nodeNum++, new AssignmentEdgeInfo(sb.toString(), vd.getIdentifier()));
    }

    @Override
    public Node visit(ArrayDeclaration ad) {
        var sb = new StringBuilder();
        sb.append(ad.getIdentifier()).append("[").append(ad.getSize()).append("]");
        return new Node("p" + this.nodeNum++, new AssignmentEdgeInfo(sb.toString(), ad.getIdentifier()));
    }

    @Override
    public Node visit(ArrayIdentifierExpression n) {
        return null;
    }

    @Override
    public Node visit(BooleanOpBBooleanNode n) {
        return null;
    }

    @Override
    public Node visit(BooleanValueExpressionNode n) {
        return null;
    }

    @Override
    public Node visit(NegationBooleanExprNode n) {
        return null;
    }

    @Override
    public Node visit(NumberExpressionNode n) {
        return null;
    }

    @Override
    public Node visit(RecAccessNode n) {
        return null;
    }

    @Override
    public Node visit(VariableIdentifierNode n) {
        return null;
    }

    @Override
    public Node visit(BooleanOpRBooleanNode n) {
        return null;
    }

    @Override
    public Node visit(ElseNode n) {
        return null;
    }
    private Node getLast(Node n){
        if(n.getTo() != null ){
            return getLast(n.getTo().getChildNode());
        }
        else return(n);
    }
    public Node visit(ElseNode n, BooleanExpressionEdgeInfo ei){
        var node = new Node("p" + nodeNum++, ei);
        var blockNode = n.getBlock().accept(this);
        addEdge(node, blockNode);
        return node;
    }

    @Override
    public Node visit(IfElseNode n) {
        var node = new Node("p" + nodeNum++, new BooleanExpressionEdgeInfo());
        var tNode = n.getBlock().accept(this);
        var e = new Edge(node.getEdgeInfo(), node, tNode);
        node.setAlternativeTo(e);
        tNode.setFrom(e);

        if(n.getElseNode() != null){
            var tmp = (BooleanExpressionEdgeInfo) node.getEdgeInfo();
            var eNode = this.visit(n.getElseNode(), tmp.getNegated());
            addEdge(node, eNode);
        }
        return node;
    }

    @Override
    public Node visit(LAssignNode n) {
        var id = n.getLeft().getIdentifier();
        var rightN = n.getRight().accept(this);
        //todo add expr info to edge label.
        return new Node("p" + nodeNum++, new AssignmentEdgeInfo(id + ":=", id));
    }

    @Override
    public Node visit(ReadStatement n) {
        //todo use n expr to get label for edge info
        return new Node("p" + nodeNum++, new VoidEdgeInfo());
    }

    @Override
    public Node visit(WhileDeclaration n) {
        var node = new Node("p" + nodeNum++, new BooleanExpressionEdgeInfo());
        var tNode = n.getBlockStatement().accept(this);
        var e = new Edge(node.getEdgeInfo(), node, tNode);
        node.setAlternativeTo(e);
        tNode.setFrom(e);
        return node;
    }

    @Override
    public Node visit(WriteStatement n) {
        //todo use n.expr to get label for edge info;
        return new Node("p" + nodeNum++, new AssignmentEdgeInfo("Write", "file"));
    }
}
