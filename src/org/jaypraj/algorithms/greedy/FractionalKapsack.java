package org.jaypraj.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * We've been given n items and their values and weights, and a knapsack with
 * capacity W. We need to fill the knapsack with the items in such a way that
 * the total value of the knapsack is maximum. We can take the fraction of an
 * item.
 *
 * @author jaymin
 *
 */
public class FractionalKapsack {
  // Driver code
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int capacity = scanner.nextInt();
      int[] val = new int[n];
      int[] wt = new int[n];

      for (int i = 0; i < n; i++) {
        val[i] = scanner.nextInt();
      }

      for (int i = 0; i < n; i++) {
        wt[i] = scanner.nextInt();
      }

      System.out.println(knapsack(wt, val, capacity));
    }
  }

  private static double knapsack(int[] wt, int[] val, int capacity) {
    int n = wt.length;
    Item[] valueToWeight = new Item[n];

    for (int i = 0; i < n; i++) {
      valueToWeight[i] = new Item(wt[i], val[i]);
    }

    // Sort the items in the decreasing order of their value to weight ratio
    Arrays.sort(valueToWeight, (o1, o2) -> Double.compare(o2.valueToWeightRatio, o1.valueToWeightRatio));

    double totalValue = 0;
    int i = 0;

    while (i < n && valueToWeight[i].weight <= capacity) {
      totalValue += valueToWeight[i].value;
      capacity -= valueToWeight[i].weight;
      i++;
    }

    if (i < n) {
      totalValue += capacity / (double) valueToWeight[i].weight * valueToWeight[i].value;
    }

    return totalValue;
  }

  private static class Item {
    private int weight;
    private int value;
    private double valueToWeightRatio;

    public Item(int weight, int value) {
      this.weight = weight;
      this.value = value;
      this.valueToWeightRatio = (double) value / weight;
    }
  }
}
