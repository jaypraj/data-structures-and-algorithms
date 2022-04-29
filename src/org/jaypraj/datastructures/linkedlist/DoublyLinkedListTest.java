package org.jaypraj.datastructures.linkedlist;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println(list.contains(20));
        System.out.println(list.remove(20));
        System.out.println();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println(list.contains(20));
        list.insertAt(1, 20);
        System.out.println();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println(list.contains(10));
        System.out.println(list.removeFirst());
        System.out.println();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println(list.contains(50));
        System.out.println(list.removeLast());
        System.out.println();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        list.insertFirst(10);

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        list.insertLast(50);

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println(list.removeAt(2));

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println();

        list.clear();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
    }
}
