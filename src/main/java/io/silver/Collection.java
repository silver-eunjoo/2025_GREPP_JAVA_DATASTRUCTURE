package io.silver;

public interface Collection<E> {

    void add(E e);

    void remove(E e);

    boolean isEmpty();

    int size();

    boolean contains(E e);


}
