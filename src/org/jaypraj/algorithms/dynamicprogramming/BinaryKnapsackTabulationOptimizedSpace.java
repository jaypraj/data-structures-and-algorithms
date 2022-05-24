package org.jaypraj.algorithms.dynamicprogramming;

public class BinaryKnapsackTabulationOptimizedSpace {
  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static int knapsack(int[] val, int[] wt, int n, int capacity) {
    // We only need two rows: one for current element and one for the previous
    // element so instead of considering (n + 1) * (capacity + 1) array we can take
    // 2 * (capacity + 1) array
    int[][] knapsack = new int[2][capacity + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= capacity; w++) {
        if (i == 0 || w == 0) {
          knapsack[i % 2][w] = 0;
        } else if (wt[i - 1] <= w) {
          knapsack[i % 2][w] = max(val[i - 1] + knapsack[(i - 1) % 2][w - wt[i - 1]], knapsack[(i - 1) % 2][w]);
        } else {
          knapsack[i % 2][w] = knapsack[(i - 1) % 2][w];
        }
      }
    }

    return knapsack[n % 2][capacity];
  }

  public static void main(String[] args) {
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };
    int capacity = 50;
    int n = val.length;
    System.out.println(knapsack(val, wt, n, capacity));
  }
}
