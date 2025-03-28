package io.silver.stack;

import io.silver.Collection;
import io.silver.stream.StackStream;
import io.silver.stream.Stream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Collection<E> {

    private Object[] elements = {};

    public void push(E e) {

        Object[] temp = new Object[elements.length + 1];

        for ( int i =0 ;i< elements.length; i++) {
            temp[i] = elements[i];
        }

        temp[elements.length] = e;
        elements = temp;
    }

    @SuppressWarnings("all")
    public E pop() {

        Object[] temp = new Object[elements.length-1];
        E target = (E) elements[elements.length - 1];

        for (int i=0;i<elements.length-1;i++){
            temp[i] = elements[i];
        }

        elements = temp;

        return target;
    }

    @SuppressWarnings("all")
    public E top() {
        return (E) elements[elements.length-1];
    }

    @Override
    public void add(E e) {
        push(e);
    }

    @Override
    public void remove(E e) {
        if (top().equals(e)) {
            pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    public void print() {
        for (Object element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }


    private class StackIterator implements Iterator<E> {

        private int curIdx = elements.length -1;

        @Override
        public boolean hasNext() {
            return curIdx >= 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) elements[curIdx--];
        }
    }

    @Override
    public Stream<E> stream() {
        return new StackStream<>(this);
    }
}
