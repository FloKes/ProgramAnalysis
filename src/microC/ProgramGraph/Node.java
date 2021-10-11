package microC.ProgramGraph;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    T data;
    Node<T> parent;
    List<Node<T>> children;

    public Node(T data) {
        this.data = data;
        this.children = new LinkedList<Node<T>>();
    }

    public Node<T> addChild(T child) {
        Node<T> childNode = new Node<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public Node<T> addEqual(T equal) {
        Node<T> equalNode = new Node<T>(equal);
        equalNode.parent = this.parent;
        this.parent.children.add(equalNode);
        return equalNode;
    }
}