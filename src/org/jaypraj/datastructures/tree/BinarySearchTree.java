package org.jaypraj.datastructures.tree;

/**
 * Represents the Binary Search Tree data structure
 *
 * @author jaymin
 *
 */
public class BinarySearchTree {

  TreeNode root;

  public BinarySearchTree() {
    this.root = null;
  }

  public BinarySearchTree(int data) {
    this.root = new TreeNode(data);
  }

  /**
   * Represents the individual node of the Binary Search Tree
   *
   * @author jaymin
   *
   */
  private class TreeNode {
    int data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int data) {
      this.data = data;
      this.parent = null;
      this.left = null;
      this.right = null;
    }

    @Override
    public String toString() {
      return String.valueOf(this.data);
    }
  }

  /**
   * Inserts a node with given data at appropriate position in the tree using
   * iteration
   *
   * @param data data to create node with
   */
  public void insert(int data) {
    insert(this.root, data);
  }

  /**
   * Inserts a new node with given data at appropriate position in the tree
   * recursively
   *
   * @param data to be inserted
   */
  public void insertRecursively(int data) {
    this.root = insertRecursively(this.root, data);
  }

  /**
   * Inserts a node with given data at appropriate position in the tree starting
   * from the node root using iteration
   *
   * @param root root node of the tree
   * @param data data to create node with
   */
  private void insert(TreeNode root, int data) {
    TreeNode iterator = root;
    TreeNode currentNode = null;

    while (iterator != null) {
      currentNode = iterator;

      if (data <= iterator.data) {
        iterator = iterator.left;
      } else {
        iterator = iterator.right;
      }
    }

    TreeNode newNode;
    if (currentNode == null) { // Tree is empty
      this.root = new TreeNode(data);
    } else if (data <= currentNode.data) {
      newNode = new TreeNode(data);
      currentNode.left = newNode;
      newNode.parent = currentNode;
    } else {
      newNode = new TreeNode(data);
      currentNode.right = newNode;
      newNode.parent = currentNode;
    }
  }

  /**
   * Insert new node recursively
   *
   * @param root root node of the tree
   * @param data value to be inserted in the tree
   * @return returns the root node of the tree after inserting the new node
   */
  private TreeNode insertRecursively(TreeNode root, int data) {
    if (root == null) {
      root = new TreeNode(data);
    } else if (data <= root.data) {
      TreeNode left = insertRecursively(root.left, data);
      left.parent = root;
      root.left = left;
    } else {
      TreeNode right = insertRecursively(root.right, data);
      right.parent = root;
      root.right = right;
    }
    return root;
  }

  /**
   * Wrapper function to search data in this tree
   *
   * @param data to be searched in this tree
   * @return node to be searched if found, null otherwise
   */
  public TreeNode search(int data) {
    return search(this.root, data);
  }

  /**
   * Search node with data in the tree starting with node root
   *
   * @param root root node of the tree
   * @param data data to be searched
   * @return node to be searched if found, null otherwise
   */
  private TreeNode search(TreeNode root, int data) {
    TreeNode iterator = root;

    while (iterator != null) {
      if (data == iterator.data)
        return iterator;
      if (data < iterator.data) {
        iterator = iterator.left;
      } else {
        iterator = iterator.right;
      }
    }

    return null;
  }

  /**
   * Wrapper function to delete the node from this tree
   *
   * @param data to be deleted
   * @return deleted node if found, null otherwise
   */
  public TreeNode delete(int data) {
    TreeNode nodeToBeDeleted = search(this.root, data);
    return nodeToBeDeleted == null ? null : delete(nodeToBeDeleted);
  }

  /**
   * Delete node from the tree
   *
   * @param node to be deleted
   * @return node after deletion
   */
  private TreeNode delete(TreeNode node) {
    TreeNode parent = node.parent;
    TreeNode left = node.left;
    TreeNode right = node.right;

    if (left == null && right == null) {
      if (parent.left == node) {
        parent.left = null;
      } else {
        parent.right = null;
      }
      node.parent = null;
    } else if (right == null) {
      parent.left = left;
      left.parent = parent;
      node.parent = null;
      node.left = null;
    } else if (left == null) {
      parent.right = right;
      right.parent = parent;
      node.parent = null;
      node.right = null;
    } else {
      TreeNode iterator = right;
      TreeNode currentNode = null;

      while (iterator != null) {
        currentNode = iterator;
        iterator = iterator.left;
      }

      int temp = node.data;
      node.data = currentNode.data;
      currentNode.data = temp;
      return delete(currentNode);
    }

    return node;
  }

  /**
   * Wrapper method to traverse tree using in-order traversal
   */
  public void inOrderTraverse() {
    inOrderTraverse(this.root);
  }

  /**
   * Traverse tree starting from the root using in-order traversal
   *
   * @param root starting node for the traversal
   */
  private void inOrderTraverse(TreeNode root) {
    if (root != null) {
      inOrderTraverse(root.left);
      System.out.print(root.data + "\t");
      inOrderTraverse(root.right);
    }
  }

  /**
   * Wrapper method to traverse tree using pre-order traversal
   */
  public void preOrderTraverse() {
    preOrderTraverse(this.root);
  }

  /**
   * Traverse tree starting from the root using pre-order traversal
   *
   * @param root starting node for the traversal
   */
  private void preOrderTraverse(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + "\t");
      preOrderTraverse(root.left);
      preOrderTraverse(root.right);
    }
  }

  /**
   * Wrapper method to traverse tree using post-order traversal
   */
  public void postOrderTraverse() {
    postOrderTraverse(this.root);
  }

  /**
   * Traverse tree starting from the root using post-order traversal
   *
   * @param root starting node for the traversal
   */
  private void postOrderTraverse(TreeNode root) {
    if (root != null) {
      postOrderTraverse(root.left);
      postOrderTraverse(root.right);
      System.out.print(root.data + "\t");
    }
  }
}
