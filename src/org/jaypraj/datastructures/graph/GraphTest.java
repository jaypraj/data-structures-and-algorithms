package org.jaypraj.datastructures.graph;

import java.util.Arrays;

public class GraphTest {

  public static void main(String[] args) {
    Graph graph = new Graph(6);
    graph.addVertices(Arrays.asList("A", "B", "C", "D", "E", "F"));
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "E");
    graph.addEdge("D", "F");

    System.out.print("DFS: ");
    graph.depthFirstTraversal("A");
    System.out.print("\nBFS: ");
    graph.breadthFirstTraversal("A");
    System.out.print("\nRecursive BFS: ");
    graph.recursiveBreadthFirstTraversal("A");
    System.out.print("\nRecursive DFS: ");
    graph.recursiveDepthFirstTraversal("A");
  }
}
