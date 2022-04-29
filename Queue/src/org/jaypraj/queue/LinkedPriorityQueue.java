package org.jaypraj.queue;

public class LinkedPriorityQueue<E> {

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    private class Node<E> {
        private E data;
        private int priority;
        private Node next;

        public Node(E data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(E data, int priority) {
        Node node = new Node(data, priority);

        if (rear == null) {
            node.next = null;
            rear = node;
        }
    }
}
