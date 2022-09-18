package com.learning.customcache;

import java.util.HashMap;
import java.util.Map;

public class EvictionPolicy {

    private DoublyLinkedList dll;
    private Map<String,Node> mapper;

    public EvictionPolicy() {
        this.dll = new DoublyLinkedList();
        this.mapper = new HashMap<>();
    }

    public void keyAccessed(String key) {
        dll.detachNode(mapper.get(key));
        dll.addNodeAtTheEnd(mapper.get(key));
    }

    public void keyAccessed(String key,String value) {
        Node node = new Node(key,value);
        mapper.put(key,node);
        dll.addNodeAtTheEnd(mapper.get(key));
    }


    public void evictKey() {
        Node node = dll.getHeadNode();
        dll.removeCurrentHead();
        mapper.remove(node);
    }

    public void removeKey(String key) {
        Node node = mapper.get(key);
        dll.detachNode(node);
        mapper.remove(key);
    }
}
