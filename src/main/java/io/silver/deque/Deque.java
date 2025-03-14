package io.silver.deque;

import io.silver.Collection;
import io.silver.linkedList.LinkedList;

public class Deque<E> implements Collection<E> {

    private final LinkedList<E> elements;

    public Deque() {
        this.elements = new LinkedList<>();
    }

    // 앞 - head, 뒤 - tail
    public void offer(E e) {
        elements.addFirst(e);
    }

    public void push(E e) {
        elements.addLast(e);
    }

    public E pop() {
//        return isEmpty() ? null : elements.removeLast();
        if ( isEmpty() ) {
            return null;
        }

        return elements.removeLast();
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }

        return elements.removeFirst();
    }

    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return elements.get(0);
    }

    public E peekLast() {
        if(isEmpty()) {
            return null;
        }
        return elements.get(elements.size()-1);
    }

    @Override
    public void add(E e) {
        push(e);
    }

    @Override
    public void remove(E e) {
        if(peek().equals(e)) {
            poll();
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean contains(E e) {
        return elements.contains(e);
    }

    public void print() {
        this.elements.traverse();
    }
}
