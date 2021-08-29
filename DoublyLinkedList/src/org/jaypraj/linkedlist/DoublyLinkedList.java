package org.jaypraj.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        Node<T> traversal = head;
        while (traversal.next != null) {
            Node<T> next = traversal.next;
            traversal.data = null;
            traversal.previous = null;
            traversal.next = null;
            traversal = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(T element) {
        if (isEmpty()) throw new RuntimeException("Linked list is empty");

        Node<T> traversal = head;
        while (traversal != null) {
            if (traversal.data.equals(element)) return true;
            traversal = traversal.next;
        }
        return false;
    }

    public void insertFirst(T element) {
        if (isEmpty()) {
            Node<T> newNode = new Node<>(element, null, null);
            head = tail = newNode;
        } else {
            Node<T> newNode = new Node<>(element, null, head);
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertLast(T element) {
        if (isEmpty()) {
            Node<T> newNode = new Node<>(element, null, null);
            head = tail = newNode;
        } else {
            Node<T> newNode = new Node<>(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insert(T element) {
        insertLast(element);
    }

    public void insertAt(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        else if (index == 0) insertFirst(element);
        else if (index == size - 1) insertLast(element);
        else {
            if (index < size / 2) {
                Node<T> traversal = head;

                for (int i = 0; i < index; i++) {
                    traversal = traversal.next;
                }

                Node<T> newNode = new Node<>(element, traversal.previous, traversal);
                traversal.previous.next = newNode;
                traversal.previous = newNode;
            } else {
                Node<T> traversal = tail;

                for (int i = size - 1; i > index; i--) {
                    traversal = traversal.previous;
                }
                Node<T> newNode = new Node<>(element, traversal.previous, traversal);
                traversal.previous.next = newNode;
                traversal.previous = newNode;
            }
            size++;
        }
    }

    public boolean remove(T element) {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        Node<T> traversal = head;

        while (traversal.next != null) {
            traversal = traversal.next;

            if (traversal.data.equals(element)) {
                traversal.previous.next = traversal.next;
                traversal.next.previous = traversal.previous;
                traversal.data = null;
                traversal.previous = null;
                traversal.next = null;
                size--;
                return true;
            }
        }

        return false;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<T> traversal;
            if (index < size / 2) {
                traversal = head;

                for (int i = 0; i < index; i++) {
                    traversal = traversal.next;
                }
            } else {
                traversal = tail;

                for (int i = size - 1; i > index; i--) {
                    traversal = traversal.previous;
                }
            }

            T data = traversal.data;
            traversal.next.previous = traversal.previous;
            traversal.previous.next = traversal.next;
            traversal.data = null;
            traversal.previous = null;
            traversal.next = null;
            size--;

            return data;
        }
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        T data = head.data;
        head.next.previous = null;
        head = head.next;
        size--;

        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        T data = tail.data;
        tail.previous.next = null;
        tail = tail.previous;
        size--;

        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> traversal = head;

            @Override
            public boolean hasNext() {
                return traversal.next != null;
            }

            @Override
            public T next() {
                return traversal.next.data;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size).append("[");
            Node<T> traversal = head;
            while (traversal.next != null) {
                sb.append(traversal.data).append(", ");
                traversal = traversal.next;
            }
            sb.append(traversal.data).append("]");

            return sb.toString();
        }
    }
}
