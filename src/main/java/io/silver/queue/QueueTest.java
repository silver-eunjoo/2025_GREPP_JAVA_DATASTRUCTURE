package io.silver.queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<String> Q = new Queue<>();

        System.out.println("큐에 값 추가");
        Q.offer("사과");
        Q.offer("참외");
        Q.offer("망고");
        Q.offer("포도");
        Q.offer("금귤");
        Q.print();

        System.out.println();
        // 큐에서 값을 제거
        System.out.println("큐에서 값을 제거");
        Q.poll();
        Q.print();

        System.out.println();

        for (String s : Q) {
            System.out.println("s = " + s);
        }

        // 큐에서 값을 제거
        System.out.println("큐에서 값을 제거");
        Q.poll();
        Q.print();

        System.out.println();

        // 큐에서 값을 제거
        System.out.println("큐에서 값을 제거");
        Q.poll();
        Q.print();

        System.out.println();
    }

}
