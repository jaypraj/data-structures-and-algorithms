package org.jaypraj.algorithms.dynamicprogramming;

/**
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. In other words,
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W
 * which represents knapsack capacity, find out the maximum value subset of
 * val[] such that sum of the weights of this subset is smaller than or equal to
 * W. You cannot break an item, either pick the complete item or don’t pick it
 * (0-1 property).
 *
 * Recursion by brute-force approach or exhaustive search
 * <strong>Approach:</strong> A simple solution is to consider all the possible
 * subsets and then calculate the weight and value of those subsets. After that
 * select the subset that has the weight less than or equal to W and maximum
 * value.
 *
 * <strong>Optimal substructure:</strong> To consider all the subsets of items,
 * there can be cases for every item. <strong>Case 1:</strong> The item is not
 * included in the optimal subset<br>
 * <strong>Case 2:</strong> The item is included in the optimal subset
 *
 * Therefore, the maximum value that can be obtained from the n items is the max
 * of the following two values:
 * <ol>
 * <li>Maximum value obtained by the n - 1 items and W weight (excluding the nth
 * item)</li>
 * <li>Value of nth item plus maximum value obtained by n - 1 items and W minus
 * weight of the nth item (including the nth item)</li>
 * </ol>
 *
 * If the weight of the nth item is greater than the weight W, then the only
 * possibility is the Case 1
 *
 * @author jaymin
 *
 */
public class BinaryKnapsackNaiveApproach {
  // Helper function to find the maximum of two integers
  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static int knapsack(int[] val, int[] wt, int n, int capacity) {
    // Base case
    if (n == 0 || capacity == 0)
      return 0;

    // If the weight of nth element is greater than the capacity W then do not
    // include it in the optimal subset
    if (wt[n - 1] > capacity)
      return knapsack(val, wt, n - 1, capacity);

    // Return the maximum of value of nth item plus value of n - 1 items and W -
    // weight of the nth item or the maximum value obtained by the n- 1 elements and
    // W capacity
    return max(knapsack(val, wt, n - 1, capacity), val[n - 1] + knapsack(val, wt, n - 1, capacity - wt[n - 1]));
  }

  public static void main(String[] args) {
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };
    int capacity = 50;
    int n = val.length;
    System.out.println(knapsack(val, wt, n, capacity));
  }
}
