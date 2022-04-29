package org.jaypraj.queue;


import java.util.Iterator;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println();

        System.out.println(queue.contains(30));
        System.out.println(queue.indexOf(30));
        System.out.println();

        System.out.println(queue.contains(60));
        System.out.println(queue.indexOf(60));
        System.out.println();

        System.out.println(queue.peek());
        System.out.println();

        System.out.println(queue.dequeue());
        System.out.println();

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println();

        System.out.println(queue.peek());
        System.out.println();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println();

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println();

        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            queue.enqueue(i * 10);
        }

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println();

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
