package org.jaypraj.algorithms.dynamicprogramming;

public class BinaryKnapsackMemoization {
  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static int knapsack(int[] val, int[] wt, int n, int capacity, int[][] knapsack) {
    // Base case
    if (n == 0 || capacity == 0)
      return 0;

    if (knapsack[n][capacity] != -1)
      return knapsack[n][capacity];

    if (wt[n - 1] > capacity)
      return knapsack[n][capacity] = knapsack(val, wt, n - 1, capacity, knapsack);

    return knapsack[n][capacity] = max(val[n - 1] + knapsack(val, wt, n - 1, capacity - wt[n - 1], knapsack),
        knapsack(val, wt, n - 1, capacity, knapsack));
  }

  public static void main(String[] args) {
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };
    int capacity = 50;
    int n = val.length;
    int[][] knapsack = new int[n + 1][capacity + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= capacity; j++) {
        knapsack[i][j] = -1;
      }
    }

    System.out.println(knapsack(val, wt, n, capacity, knapsack));
  }
}
