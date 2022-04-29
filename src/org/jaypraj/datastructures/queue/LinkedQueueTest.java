package org.jaypraj.datastructures.queue;

public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        queue.enqueue(5);

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        queue.enqueue(10);

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        queue.enqueue(15);

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        System.out.println(queue.dequeue());
        System.out.println();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        System.out.println(queue.peek());
        System.out.println();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println();

        System.out.println(queue.dequeue());
        System.out.println();
    }
}
