package io.silver.arrayList;

import io.silver.Collection;

public interface List<E> extends Collection<E> {

    void add(int index, E e);

    E get(int index);

    E remove(int index);

    E set(int index, E e);

}
