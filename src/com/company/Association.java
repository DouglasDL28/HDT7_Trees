package com.company;

import java.util.Map;

public class Association<K,V> implements Map.Entry<K,V> {
    protected K key;
    protected V value;

    public Association (K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        return this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ": " + value + ")";
    }
}
