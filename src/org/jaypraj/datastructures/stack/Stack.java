package org.jaypraj.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<E> implements Iterable<E> {

  private LinkedList<E> list = new LinkedList<>();

  public Stack() {
  }

  public Stack(E element) {
    push(element);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void push(E element) {
    list.addLast(element);
  }

  public E pop() {
    if (isEmpty()) throw new EmptyStackException();
    return list.removeLast();
  }

  public E peek() {
    if (isEmpty()) throw new EmptyStackException();
    return list.peek();
  }

  public void clear() {
    list.clear();
  }

  public int search(Object o) {
    if (isEmpty()) throw new EmptyStackException();
    return list.lastIndexOf(o);
  }

  @Override
  public Iterator<E> iterator() {
    return list.iterator();
  }

  @Override
  public String toString() {
    return list.toString();
  }
}
