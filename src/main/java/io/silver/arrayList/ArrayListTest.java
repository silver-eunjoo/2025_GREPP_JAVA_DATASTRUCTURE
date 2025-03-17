package io.silver.arrayList;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();


        // 반복자 패턴 For-each문 Iterable을 구현하지않으면 동작 x
//        for (String el : list) {
//                // 동작하지 않는다.
//        }

        System.out.println("배열에 값 추가");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");


        for (String s: list){
            System.out.println("s = " + s);
        }

        list.print();
        System.out.println();

        System.out.println("특정 인덱스에 값 추가");
        list.print();
        System.out.println("0번 인덱스에 5 추가");
        list.add(0,"5");
        list.print();

        System.out.println();

        System.out.println("특정 인덱스 값 삭제");
        list.print();
        System.out.println("1번 인덱스에 있는 값 삭제");
        list.remove(1);
        list.print();

        System.out.println();

        System.out.println("배열에 중복되는 값 5 추가");
        list.add("5");
        list.print();

        System.out.println("배열에 중복되는 값 5 제거");
        list.remove("5");
        list.print();

        System.out.println();

        System.out.println("0번 인덱스의 값 꺼내오기");
        list.print();
        String value = list.get(0);
        System.out.println("value = " + value);

    }
}
