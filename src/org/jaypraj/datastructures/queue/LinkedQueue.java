package org.jaypraj.datastructures.queue;

public class LinkedQueue<E> {

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E data) {
        Node node = new Node(data);

        if (front == null && rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }

        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        Node node = front;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }

        size--;
        return node.data;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return front.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (Node node = front; node != null; node = node.next) {
            builder.append(node).append(" ");
        }

        return builder.toString().trim();
    }
}
