package io.silver.stream;

import io.silver.Collection;
import io.silver.arrayList.ArrayList;
import io.silver.linkedList.LinkedList;
import io.silver.queue.Queue;
import io.silver.stack.Stack;

import java.util.Iterator;
import java.util.function.Consumer;

public abstract class AbstractStream<T> implements Stream<T>{

    protected final Collection<T> collection;
    protected abstract Iterator<T> iterator();

    public AbstractStream(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        Iterator<T> iterator = iterator();

        while ( iterator.hasNext() ) {
            consumer.accept(iterator.next());
        }
    }

    protected <R> Collection<R> getCollection() {
        if (this.collection instanceof LinkedList<?> ) {
            return new LinkedList<>();
        } else if (this.collection instanceof Stack<?>) {
            return new Stack<>();
        } else if (this.collection instanceof Queue<?>)  {
            return new Queue<>();
        }


        return new ArrayList<>();
    }
}
