package io.silver.stream;

import io.silver.Collection;
import java.awt.List;

public class StackStream<T> extends ListStream<T> {

    public StackStream(Collection<T> collection) {
        super(collection);
    }
}
