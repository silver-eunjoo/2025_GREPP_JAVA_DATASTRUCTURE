package io.silver;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    public static void main(String[] args) {

        List<String> strings = List.of("one", "two", "three", "four", "five");

        strings.stream()
                .filter(e -> e.length() >= 4)
                .forEach(e -> System.out.println(e));
    }
}
