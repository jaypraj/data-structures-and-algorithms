package org.jaypraj.queue;

class MyCircularQueue {

    private int[] data;
    private int front, rear;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        front = rear = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        // We can use rear = (rear + 1) % size in place of below two conditions
        } else if (rear == this.size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        data[rear] = value;

        // We can use this.isEmpty() and then set front to 0
        if (front == -1) {
            front++;
        }

        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }

        if (front == rear) {
            front = rear = -1;
        // We can use front = (front + 1) % size in place of below two conditions
        } else if (front == this.size - 1) {
            front = 0;
        } else {
            front++;
        }

        return true;
    }

    public int Front() {
        return this.isEmpty() ? -1 : data[front];
    }

    public int Rear() {
        return this.isEmpty() ? -1 : data[rear];
    }

    public boolean isEmpty() {
        // We can only check for front == 0
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        // We can check for (rear + 1) % size == front
        return front == 0 && rear == this.size - 1
                || rear == front - 1;
    }
}

public class CircularQueueMain {
    public static void main(String[] args) {
        int k = 8;
        MyCircularQueue obj = new MyCircularQueue(k);
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(9));
        System.out.println(obj.enQueue(5));
        System.out.println(obj.enQueue(0));
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.isEmpty());
        System.out.println(obj.isEmpty());
        System.out.println(obj.Rear());
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
    }
}