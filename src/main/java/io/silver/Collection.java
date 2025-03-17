package io.silver;

import io.silver.stream.Stream;

public interface Collection<E> extends Iterable<E>{

    void add(E e);

    void remove(E e);

    boolean isEmpty();

    int size();

    boolean contains(E e);

    Stream<E> stream();

}
