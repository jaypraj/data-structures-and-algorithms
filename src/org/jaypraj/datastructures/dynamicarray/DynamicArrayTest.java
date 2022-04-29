package org.jaypraj.datastructures.dynamicarray;

import java.util.Iterator;

public class DynamicArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();

        System.out.println(arr);
        System.out.println(arr.isEmpty());
        System.out.println(arr.size());
        arr.add(10);
        arr.add(20);
        arr.add(30);
        System.out.println(arr.isEmpty());
        System.out.println(arr.size());
        System.out.println(arr);
        System.out.println(arr.get(1));
        System.out.println(arr.contains(20));
        System.out.println(arr.contains(40));
        System.out.println(arr.remove(20));
        System.out.println(arr);
        arr.add(40);
        System.out.println(arr);
        System.out.println(arr.removeAt(2));
        System.out.println(arr.indexOf(30));
        Iterator iterator = arr.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        arr.set(1, 50);
        System.out.println(arr);
        for (int i = 0; i < 50; i++) {
            arr.add(i * 2);
        }
        System.out.println(arr.size());
        System.out.println(arr);
        arr.add(new Integer[] {10, 20});
        System.out.println(arr.size());
        System.out.println(arr);
    }
}
