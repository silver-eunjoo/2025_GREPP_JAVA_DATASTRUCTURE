package io.silver.stream;

import io.silver.Collection;

public class QueueStream<T> extends ListStream<T> {

    public QueueStream(Collection<T> collection) {
        super(collection);
    }
}
