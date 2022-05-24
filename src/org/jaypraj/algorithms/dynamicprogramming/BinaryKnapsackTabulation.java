package org.jaypraj.algorithms.dynamicprogramming;

public class BinaryKnapsackTabulation {
  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static int knapsack(int[] val, int[] wt, int n, int capacity) {
    int[][] knapsack = new int[n + 1][capacity + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= capacity; w++) {
        if (i == 0 || w == 0) {
          knapsack[i][w] = 0;
          // We're taking (i - 1)th weight into account because wt array is 0-based and
          // knapsack[][] has one more column and row
        } else if (wt[i - 1] <= w) {
          knapsack[i][w] = max(val[i - 1] + knapsack[i - 1][w - wt[i - 1]], knapsack[i - 1][w]);
        } else {
          knapsack[i][w] = knapsack[i - 1][w];
        }
      }
    }

    return knapsack[n][capacity];
  }

  public static void main(String[] args) {
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };
    int capacity = 50;
    int n = val.length;
    System.out.println(knapsack(val, wt, n, capacity));
  }
}
