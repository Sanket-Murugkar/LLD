package com.learning.customcache;

public class DoublyLinkedList {

    private Node headNode;
    private Node tailNode;

    public void detachNode(Node key) {
        //Detach B
        // A  <-> B <-> C
        // A <-> C
        key.getNextNode().setPrevNode(key.getPrevNode());
        key.getPrevNode().setNextNode(key.getNextNode());
        key.setPrevNode(null);
        key.setNextNode(null);

    }

    public void addNodeAtTheEnd(Node node) {
        tailNode.setNextNode(node);
        node.setPrevNode(tailNode);
        tailNode=node;
    }

    public void removeCurrentHead() {
        headNode = headNode.getNextNode();
        headNode.setPrevNode(null);
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode(){
        return tailNode;
    }
}
