package io.silver.stream;

import io.silver.arrayList.ArrayList;
import io.silver.arrayList.List;
import io.silver.queue.Queue;

public class StreamTest {

    public static void main(String[] args) {
        Queue<Integer> Q = new Queue<>();

        Q.add(1);
        Q.add(1);
        Q.add(2);
        Q.add(2);
        Q.add(3);
        Q.add(1);

        List<Integer> list = new ArrayList<>();

        for (Integer n : Q) {
            list.add(n*2);
        }

//        List<Integer> list = Q.stream()
//                .map(n -> n * 2)
//                .toList();

        System.out.println(list.size());

        List<Integer> result = list.stream()
                .filter(n -> n == 2)
                .toList();

        System.out.println(result.size());
    }
}
