package com.learning.customcache;

import java.util.Map;

public class Storage {

    Map<String,String> storage;
    private final Integer capacity;

    public Storage(Integer capacity) {
        this.capacity = capacity;
    }

    public void add(String key, String value){

        storage.put(key,value);
    }

    public String get(String key){

        return null;
    }

    public void remove(String key){
        if(storage.containsKey(key)){
            storage.remove(key);
        }
    }

    public boolean isFull() {
        return storage.size()==capacity;
    }

}
