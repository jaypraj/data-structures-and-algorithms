package org.jaypraj.dynamicarray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {
    private T[] arr;
    private int len = 0;
    private int capacity;

    public Array() {
        this(16);
    }

    public Array(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= len) throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        return arr[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= len) throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T element) {
        if (len + 1 >= capacity) {
            increaseCapacity();
        }

        arr[len++] = element;
    }

    public void add(T[] elements) {
        if (len + 1 >= capacity || elements.length + len >= 2 * capacity) {
            increaseCapacity();
        }

        for (int i = 0, j = len; i < elements.length; i++, j++) {
            arr[j] = elements[i];
        }

        len += elements.length;
    }

    private void increaseCapacity() {
        if (capacity == 0) capacity = 1;
        else capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < len; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    public T removeAt(int index) {
        if (index >= len || index < 0) throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        T data = arr[index];
        T[] newArray = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == index) j--;
            else newArray[j] = arr[i];
        }
        arr = newArray;
        capacity = --len;
        return data;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(arr[i]).append(", ");
            }
            sb.append(arr[len - 1]).append("]");
            return sb.toString();
        }
    }
}
