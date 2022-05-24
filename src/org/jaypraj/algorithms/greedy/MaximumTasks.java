package org.jaypraj.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * We've been a given a list of n tasks and the amount of time it takes to
 * finish the each task. We need to find the maximum number of tasks that we can
 * finish in the given amount of time T.
 *
 * @author jaymin
 *
 */
public class MaximumTasks {
  // Driver code
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int time = sc.nextInt();
      int n = sc.nextInt();
      int[] tasks = new int[n];

      for (int i = 0; i < n; i++) {
        tasks[i] = sc.nextInt();
      }

      System.out.println("Maximum tasks can be finished in " + time + " is: " + findMaximumTasks(time, n, tasks));
    }
  }

  private static int findMaximumTasks(int time, int n, int[] tasks) {
    int totalTime = 0;
    int numOfTasks = 0;

    // Sort the tasks in the increasing order of their completion time
    Arrays.sort(tasks);

    // Iterate over each task until the total time is greater than or equal to the
    // given time, and add time of each task to the total time and increment the
    // number of tasks
    int i = 0;
    while (i < n && totalTime < time) {
      if (tasks[i] <= time - totalTime) {
        totalTime += tasks[i];
        numOfTasks++;
      }
      i++;
    }

    return numOfTasks;
  }
}
