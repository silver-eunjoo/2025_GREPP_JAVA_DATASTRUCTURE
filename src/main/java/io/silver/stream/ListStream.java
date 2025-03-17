package io.silver.stream;

import io.silver.Collection;
import io.silver.arrayList.ArrayList;
import io.silver.arrayList.List;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListStream<T> extends AbstractStream<T>{

    public ListStream(Collection<T> collection) {
        super(collection);
    }

    @Override
    protected Iterator<T> iterator() {
        return this.collection.iterator();
    }
    @Override
    public Stream<T> filter(Predicate<? super T> predicate) { // Predicate -> test (검사)

        /*

        filter(
            () -> {

            }
         );
         */

        // Predicate pre = (T t) -> { return t.equals(...) };
        // for-each
        // if ()

        Iterator<T> iterator = iterator();
        Collection<T> result = getCollection();

        while( iterator.hasNext() ) {
            T item = iterator.next();
            if ( predicate.test(item) ) {
                result.add(item);
            }
        }

        return new ListStream<>(result);
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {

        Collection<R> result = getCollection();

//        for (T t : collection) {
//            result.add(mapper.apply(t));
//        }

        forEach(el -> result.add(mapper.apply(el)));


        return new ListStream<>(result);
    }


    @Override
    public List<T> toList() {

        List<T> list = new ArrayList<>();

        Iterator<T> iterator = iterator();

        while(iterator.hasNext()) {
            T item = iterator.next();
            list.add(item);
        }

        return list;
    }
}
