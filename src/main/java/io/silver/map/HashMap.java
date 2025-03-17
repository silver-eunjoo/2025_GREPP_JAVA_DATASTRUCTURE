package io.silver.map;

import io.silver.Collection;
import io.silver.arrayList.ArrayList;
import io.silver.linkedList.LinkedList;

public class HashMap<K,V> implements Map<K,V>{

    private static final int CAPACITY = 16;
    private final LinkedList<Node<K,V>>[] buckets; // 고정길이 배열

    private int size;

    public HashMap() {
        this.buckets = new LinkedList[CAPACITY]; // { null, null, ... }
        for (int i=0; i<CAPACITY;i++){
            buckets[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % CAPACITY; // 모듈러 연산으로
    }

    @Override
    public V put(K key, V value) {

        int idx = getHash(key);

        LinkedList<Node<K, V>> bucket = buckets[idx];

        for (Node<K, V> node : bucket) {
            if( node.key.equals(key) ) {
                node.value = value;
                return value;
            }
        }

        bucket.add(new Node<>(key, value));
        size++;

        return value;
    }

    @Override
    public V get(K key) {

        int idx = getHash(key);

        LinkedList<Node<K, V>> bucket = buckets[idx];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    @Override
    public V remove(K key) {

        int idx = getHash(key);
        LinkedList<Node<K, V>> bucket = buckets[idx];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return node.value;
            }
        }

        return null;
    }

    @Override
    public V replace(K key, V value) {

        int idx = getHash(key);
        LinkedList<Node<K, V>> bucket = buckets[idx];

        for (Node<K, V> node : bucket) {
            if(node.key.equals(key)) {
                V originValue = node.value;
                node.value = value;
                return originValue;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {

        ArrayList<V> valueList = new ArrayList<>();

        for (LinkedList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                valueList.add(node.value);
            }
        }

        return valueList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        if (key == null) return false;
        int idx = getHash((K) key);

        LinkedList<Node<K, V>> bucket = buckets[idx];

        for (Node<K, V> node : bucket) {
            if( node.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        for (LinkedList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                if(node.value.equals(value)) {
                    return true;
                }
            }
        }

//        Collection<V> values = values();
//        for (V v : values) {
//            if (v.equals(value)) {
//                return true;
//            }
//        }

        return false;
    }

    private static class Node<K,V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
