package org.jaypraj.datastructures;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();

        System.out.println(stack.peek());
        System.out.println();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();

        stack.clear();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();
    }
}
