package com.learning.customcache;

public class Cache {

    private Storage storage;
    private EvictionPolicy evictionPolicy;

    public Cache(Storage storage, EvictionPolicy evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public String get(String key){
        String value = this.storage.get(key);
        evictionPolicy.keyAccessed(key);
        return value;
    }

    public void put(String key, String value){
        if(this.storage.isFull()){
            this.evictionPolicy.evictKey();
        }
        this.storage.add(key,value);
        evictionPolicy.keyAccessed(key,value);
    }

    public void remove(String key){
        this.storage.remove(key);
        this.evictionPolicy.removeKey(key);
    }

}
