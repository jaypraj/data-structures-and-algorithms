package org.jaypraj.datastructures.tree;

public class BSTMain {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insertRecursively(3);
    tree.insertRecursively(1);
    tree.insertRecursively(5);
    tree.insertRecursively(0);
    tree.insertRecursively(2);
    tree.insertRecursively(4);
    tree.insertRecursively(6);
    tree.insertRecursively(7);

    tree.inOrderTraverse();
    System.out.println();
    tree.preOrderTraverse();
    System.out.println();
    tree.postOrderTraverse();
    System.out.println();

    System.out.println(tree.delete(6));

    tree.inOrderTraverse();
    System.out.println();
    tree.preOrderTraverse();
    System.out.println();
    tree.postOrderTraverse();
    System.out.println();

    System.out.println(tree.search(6));

    //    System.out.println(tree.search(5));
    //    System.out.println(tree.search(-1));
  }
}
