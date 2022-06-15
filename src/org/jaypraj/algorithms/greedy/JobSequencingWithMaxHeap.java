package org.jaypraj.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Calculate the maximum profit by scheduling the jobs given with their
 * deadlines and profit<br>
 *
 * Time Complexity: O(n log(n))<br>
 * Space Complexity: O(n)
 *
 * @author jaymin
 *
 */
public class JobSequencingWithMaxHeap {
  // Driver code
  public static void main(String[] args) {
    List<Job> arr = new ArrayList<>();

    arr.add(new Job('a', 2, 100));
    arr.add(new Job('b', 1, 19));
    arr.add(new Job('c', 2, 27));
    arr.add(new Job('d', 1, 25));
    arr.add(new Job('e', 3, 15));

    System.out.println("Following is maximum profit sequence of jobs");
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

    // Sorting the jobs in the order of their deadlines
    Collections.sort(arr, (a, b) -> a.deadline - b.deadline);

    // Store the scheduled jobs
    List<Job> result = new ArrayList<>();
    // Max heap for storing jobs with profit as their priority
    PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

    // Iterate over jobs in the reverse order
    for (int i = n - 1; i >= 0; i--) {
      int availableSlots;

      // Slots will be the difference between ith and (i - 1)th job's deadline except
      // for the first job
      if (i == 0) {
        availableSlots = arr.get(i).deadline;
      } else {
        availableSlots = arr.get(i).deadline - arr.get(i - 1).deadline;
      }

      maxHeap.add(arr.get(i));

      // Until the slots are empty or we don't have any jobs to scedule
      while (availableSlots > 0 && maxHeap.size() > 0) {
        result.add(maxHeap.remove());
        availableSlots--;
      }
    }

    // Sort the result jobs according to their deadlines
    Collections.sort(result, (a, b) -> a.deadline - b.deadline);
    int maxProfit = 0;
    for (Job job : result) {
      System.out.print(job.id + " ");
      maxProfit += job.profit;
    }
    System.out.println();

    return maxProfit;
  }
}
