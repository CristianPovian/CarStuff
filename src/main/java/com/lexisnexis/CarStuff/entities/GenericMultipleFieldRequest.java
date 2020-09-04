package com.lexisnexis.CarStuff.entities;

import java.util.Map;

public class GenericMultipleFieldRequest <K,V>{
    private Map<K,V> requests;

    public Map<K, V> getRequests() { return requests; }

    public void setRequests(Map<K, V> requests) {
        this.requests = requests;
    }
}
