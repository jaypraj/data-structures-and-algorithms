package org.jaypraj.datastructures.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
  // List of vertices
  private List<String> vertices;

  // Map of edges (adjacency list)
  private Map<Integer, LinkedList<Integer>> edges;

  public Graph() {
    vertices = new ArrayList<>();
    edges = new HashMap<>();
  }

  public Graph(int numberOfVertices) {
    vertices = new ArrayList<>(numberOfVertices);
    edges = new HashMap<>(numberOfVertices);

    for (int i = 0; i < numberOfVertices; i++) {
      edges.put(i, new LinkedList<>());
    }
  }

  public void addVertices(List<String> vertices) {
    this.vertices = vertices;
  }

  public void addEdge(String startVertex, String endVertex) {
    if (!vertices.contains(startVertex) || !vertices.contains(endVertex)) {
      System.out.println("Graph doesn't contain either " + startVertex + " or " + endVertex + "!");
      return;
    }

    int startVertexIndex = vertices.indexOf(startVertex);
    int endVertexIndex = vertices.indexOf(endVertex);

    edges.get(startVertexIndex).add(endVertexIndex);
  }

  // Depth-first traversal
  public void depthFirstTraversal(String sourceVertex) {
    if (!vertices.contains(sourceVertex)) {
      System.out.println("The graph doesn't contain the " + sourceVertex + "!");
      return;
    }

    int sourceVertexIndex = vertices.indexOf(sourceVertex);
    Deque<Integer> stack = new LinkedList<>();
    boolean[] visited = new boolean[vertices.size()];

    // Add source vertex to the stack
    stack.push(sourceVertexIndex);

    while (!stack.isEmpty()) {
      int vertexIndex = stack.pop();

      // Check whether the vertex is already visited
      if (!visited[vertexIndex]) {
        // Mark the vertex as visited and print it's value
        visited[vertexIndex] = true;
        System.out.print(vertices.get(vertexIndex) + " ");

        // Add the adjacent vertices to the stack
        for (int adjacentVertexIndex : edges.get(vertexIndex)) {
          stack.push(adjacentVertexIndex);
        }
      }
    }
  }

  // Breadth-first traversal
  public void breadthFirstTraversal(String sourceVertex) {
    if (!vertices.contains(sourceVertex)) {
      System.out.println("The graph doesn't contain the vertex " + sourceVertex + "!");
      return;
    }

    int sourceVertexIndex = vertices.indexOf(sourceVertex);
    Deque<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[vertices.size()];

    // Add source vertex to the Queue
    queue.offer(sourceVertexIndex);

    while (!queue.isEmpty()) {
      int vertexIndex = queue.poll();

      // Check whether the vertex is already visited
      if (!visited[vertexIndex]) {
        // Mark the vertex as visited
        visited[vertexIndex] = true;
        System.out.print(vertices.get(vertexIndex) + " ");

        // Add the adjacent vertices to the queue
        for (int adjacentVertexIndex : edges.get(vertexIndex)) {
          queue.offer(adjacentVertexIndex);
        }
      }
    }
  }

  // Recursive breadth-first traversal
  public void recursiveBreadthFirstTraversal(String sourceVertex) {
    if (!vertices.contains(sourceVertex)) {
      System.out.println("The graph doesn't contain the vertex " + sourceVertex + "!");
      return;
    }

    Deque<Integer> queue = new LinkedList<>();
    queue.offer(vertices.indexOf(sourceVertex));
    boolean[] visited = new boolean[vertices.size()];

    recursiveBfsHelper(queue, visited);
  }

  private void recursiveBfsHelper(Deque<Integer> queue, boolean[] visited) {
    // Check whether queue is empty
    if (!queue.isEmpty()) {
      // Remove the first element of the queue
      int vertexIndex = queue.poll();

      // Check whether the first node is already visited
      if (!visited[vertexIndex]) {
        // Mark the vertex as visited and print it
        visited[vertexIndex] = true;
        System.out.print(vertices.get(vertexIndex) + " ");

        // Add all of it's adjacent vertices to the queue
        for (int adjacentVertexIndex : edges.get(vertexIndex)) {
          queue.offer(adjacentVertexIndex);
        }

        recursiveBfsHelper(queue, visited);
      }
    }
  }

  // Recursive DFS
  public void recursiveDepthFirstTraversal(String sourceVertex) {
    if (!vertices.contains(sourceVertex)) {
      System.out.println("The graph doesn't contain the vertex " + sourceVertex + "!");
      return;
    }

    boolean[] visited = new boolean[vertices.size()];
    recursiveDfsHelper(vertices.indexOf(sourceVertex), visited);
  }

  private void recursiveDfsHelper(int vertexIndex, boolean[] visited) {
    // Check whether the vertex is already visited
    if (!visited[vertexIndex]) {
      // If not then mark as visited and print it
      visited[vertexIndex] = true;
      System.out.print(vertices.get(vertexIndex) + " ");

      for (int adjacentVertexIndex : edges.get(vertexIndex)) {
        recursiveDfsHelper(adjacentVertexIndex, visited);
      }
    }
  }
}
