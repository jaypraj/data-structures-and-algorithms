package org.jaypraj.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find the maximum profit by completing the jobs with their deadlines and
 * profit given using the brute-force approach<br>
 *
 * Time Complexity: O(n^2)<br>
 * Space Complexity: O(n)
 *
 * @author jaymin
 *
 */
public class JobSequencingProblem {
  // Driver code
  public static void main(String[] args) {
    List<Job> arr = new ArrayList<>();
    arr.add(new Job('a', 2, 100));
    arr.add(new Job('b', 1, 19));
    arr.add(new Job('c', 2, 27));
    arr.add(new Job('d', 1, 25));
    arr.add(new Job('e', 3, 15));

    System.out.println("The job sequence for the maximum profit:");
    System.out.println("Max profit: " + printJobScheduling(arr));
  }

  static class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
      this.id = id;
      this.deadline = deadline;
      this.profit = profit;
    }
  }

  private static int printJobScheduling(List<Job> arr) {
    int n = arr.size();

    // Sort the jobs in the decreasing order of their profit
    Collections.sort(arr, (a, b) -> b.profit - a.profit);

    // To keep track of the available slots
    boolean[] slots = new boolean[n];

    // To store the sequence of jobs
    char[] result = new char[n];

    // Store the maximum profit
    int profit = 0;

    // Iterate over all the jobs
    for (int i = 0; i < n; i++) {
      // Find a free slot for this job
      // Please note that we're starting from the last possible slot
      for (int j = min(arr.get(i).deadline - 1, n - 1); j >= 0; j--) {
        if (!slots[j]) {
          slots[j] = true;
          result[j] = arr.get(i).id;
          profit += arr.get(i).profit;
          break;
        }
      }
    }

    for (char job : result) {
      System.out.print(job + " ");
    }
    System.out.println();

    return profit;
  }

  private static int min(int a, int b) {
    return a < b ? a : b;
  }
}
