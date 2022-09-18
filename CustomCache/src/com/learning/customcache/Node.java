package com.learning.customcache;

public class Node {

    private String value;
    private Node prevNode;
    private Node nextNode;


    public Node(String value, String s) {
        this.value = value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }
}
