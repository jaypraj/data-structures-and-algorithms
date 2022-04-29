package org.jaypraj.datastructures.tree;

public class BSTMain {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(3);
    tree.insert(1);
    tree.insert(5);
    tree.insert(0);
    tree.insert(2);
    tree.insert(4);
    tree.insert(6);
    //    tree.insert(7);

    tree.inOrderTraverse();
    System.out.println();
    tree.preOrderTraverse();
    System.out.println();
    tree.postOrderTraverse();
    System.out.println();

    System.out.println(tree.delete(-1));

    tree.inOrderTraverse();
    System.out.println();
    tree.preOrderTraverse();
    System.out.println();
    tree.postOrderTraverse();
    System.out.println();

    System.out.println(tree.search(-1));

    //    System.out.println(tree.search(5));
    //    System.out.println(tree.search(-1));
  }
}
