package org.jaypraj.algorithms.dynamicprogramming;

public class BinaryKnapsackTabulationMoreOptimizedSpace {
  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static int knapsack(int[] val, int[] wt, int n, int capacity) {
    int[] knapsack = new int[capacity + 1];

    for (int i = 1; i <= n; i++) {
      for (int w = capacity; w >= 0; w--) {
        if (wt[i - 1] <= w) {
          knapsack[w] = max(knapsack[w], val[i - 1] + knapsack[w - wt[i - 1]]);
        }
      }
    }

    return knapsack[capacity];
  }

  public static void main(String[] args) {
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };
    int capacity = 50;
    int n = val.length;
    System.out.println(knapsack(val, wt, n, capacity));
  }
}
