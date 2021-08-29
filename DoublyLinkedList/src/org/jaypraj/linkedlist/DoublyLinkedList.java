package org.jaypraj.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T> {
        private T data;
        private Node<T> previous;
        private Node<T> next;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * Returns the size of the list
     * @return int size
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the list is empty
     * @return true if the list is empty, else false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Remove all elements from the list
     */
    public void clear() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        Node<T> traversal = head;
        while (traversal != null) {
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

    /**
     * Get the index of the element
     * @param element
     * @return int index
     */
    public int indexOf(T element) {
        if (isEmpty()) throw new RuntimeException("Empty list");

        int i = 0;
        Node<T> traversal = head;
        if (element == null) {
            for (; traversal != null; i++, traversal = traversal.next) {
                if (traversal.data == null) {
                    return i;
                }
            }
        } else {
            for (; traversal != null; i++, traversal = traversal.next) {
                if (element.equals(traversal.data)) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Checks whether the list contains the element
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    /**
     * Adds an element to the start of the list
     * @param element
     */
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

    /**
     * Adds an element at the end of the list
     * @param element
     */
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

    /**
     * Adds an element at the end of the list
     * @param element
     */
    public void insert(T element) {
        insertLast(element);
    }

    /**
     * Adds an element at the specific index
     * @param index at which the element needs to be added
     * @param element which needs to be added
     */
    public void insertAt(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(index);
        else if (index == 0) insertFirst(element);
        else if (index == size) insertLast(element);
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
            Node<T> newNode = new Node<>(element, traversal.previous, traversal);
            traversal.previous.next = newNode;
            traversal.previous = newNode;

            size++;
        }
    }

    /**
     * Removes the node from the list
     * @param node which needs to be removed
     * @return data of the removed node
     */
    private T remove(Node<T> node) {
        if (node.previous == null) return removeFirst();
        else if (node.next == null) return removeLast();
        else {
            node.next.previous = node.previous;
            node.previous.next = node.next;

            T data = node.data;
            node.data = null;
            node.previous = null;
            node.next = null;
            size--;

            return data;
        }
    }

    /**
     * Removes node that contains the element from the list
     * @param element which needs to be removed
     * @return true if the element successfully removed, else false
     */
    public boolean remove(T element) {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        Node<T> traversal;

        if (element == null) {
            for (traversal = head; traversal != null; traversal = traversal.next) {
                if (traversal.data == null) {
                    remove(traversal);
                    return true;
                }
            }
        } else {
            for (traversal = head; traversal != null; traversal = traversal.next) {
                if (element.equals(traversal.data)) {
                    remove(traversal);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Removes the element from specified index
     * @param index from which the element needs to be removed
     * @return data of the removed element
     */
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

            return remove(traversal);
        }
    }

    /**
     * Removes the first node from the list
     * @return the removed node
     */
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        } else {
            head.previous = null;
        }

        return data;
    }

    /**
     * Removes the last node from the list
     * @return the last node
     */
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Linked List is empty");

        T data = tail.data;
        tail = tail.previous;
        size--;

        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }

        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> traversal = head;

            @Override
            public boolean hasNext() {
                return traversal != null;
            }

            @Override
            public T next() {
                T data = traversal.data;
                traversal = traversal.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
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
