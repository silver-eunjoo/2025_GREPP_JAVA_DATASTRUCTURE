package io.silver.stream;

import io.silver.arrayList.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Stream<T> {

    // Collection을 구현한 자료구조
    // 반복자를 예쁘게 적용하기 위한 것
    // 자료구조 안에 있는 값들을 흐름으로 만들고, 이를 제어하기 위한 인터페이스

    // map(Function<T, R>) -> foreach로 순회해서 반환해준다.
    // filter() -> Predicate<T> -> 조건에 맞냐 안 맞냐를 걸러서 boolean을 반환해준다.
    // forEach() -> Consumer -> foreach 반환하진 않고 흘러주는 것
    // toList()

    <R> Stream<R> map(Function<? super T, ? extends R> mapper);

    Stream<T> filter(Predicate<? super T> predicate);
    void forEach(Consumer<? super T> consumer);
    List<T> toList();



}
