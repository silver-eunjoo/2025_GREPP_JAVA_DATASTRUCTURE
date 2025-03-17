package io.silver.map;

import io.silver.Collection;

public interface Map<K,V> {

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    V replace(K key, V value);

    int size();

    Collection<V> values();

    boolean isEmpty();

    boolean containsKey(Object key);
    boolean containsValue(Object value);



}
