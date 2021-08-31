package org.jaypraj.queue;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayQueue<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private int capacity;
    private E[] queue;
    private int front;
    private int back;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        size = 0;
        queue = (E[]) new Object[capacity];
        front = back = -1;
    }

    /**
     * Returns the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the queue is empty
     * @return returns true if the queue is empty, else false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds an element at the back of the queue
     * @param element element to be added
     */
    public void enqueue(E element) {
        if (front == -1) {
            front++;
        }

        if (size >= capacity || back >= capacity - 1) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            E[] newQueue = (E[]) new Object[capacity];
            for (int i = front, j = 0; i <= back; i++, j++) {
                newQueue[j] = queue[i];
            }
            queue = newQueue;
            front = 0;
            back = size - 1;
        }
        queue[++back] = element;
        size++;
    }

    /**
     * Removes an element from the front of the queue
     * @return returns the removed element
     */
    public E dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");

        E element = queue[front];
        queue[front++] = null;
        size--;

        if (isEmpty()) {
            front = back = -1;

            for (int i = 0; i < capacity; i++) {
                queue[i] = null;
            }
        }

        return element;
    }

    /**
     * Returns the first element without removing it
     * @return returns the first element
     */
    public E peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");

        return queue[front];
    }

    /**
     * Returns the index of the element in the queue
     * @param o element to be searched
     * @return returns the index of the element if present, else -1
     */
    public int indexOf(Object o) {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");

        for (int i = front; i <= back; i++) {
            if (queue[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Checks whether the element is present in the queue
     * @param o element to be checked
     * @return returns true if the element is present, else false
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int index = front;

            @Override
            public boolean hasNext() {
                return index <= back;
            }

            @Override
            public E next() {
                return queue[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        final StringBuilder sb = new StringBuilder("[");
        for (int i = front; i < back; i++) {
            sb.append(queue[i]).append(", ");
        }
        sb.append(queue[back]).append(']');
        return sb.toString();
    }
}
