package org.jaypraj.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We are given the list of activities and their start time and finish time. We
 * need to find maximum number tasks a single person can finish assuming that a person
 * can work on a single task at a time.
 *
 * Consider the following 6 activities.
 *        start[]  =  {1, 3, 0, 5, 8, 5};
 *        finish[] =  {2, 4, 6, 7, 9, 9};
 *   The maximum set of activities that can be executed
 *   by a single person is {0, 1, 3, 4}
 *
 * @author jaymin
 *
 */
public class ActivitySelection {
  // Driver code
  public static void main(String[] args) {
    int[] start = new int[] { 1, 3, 0, 5, 8, 5 };
    int[] finish = new int[] { 2, 4, 6, 7, 9, 9 };
    int n = start.length;

    // To find the maximum number of activities finished by a single person we need
    // to find select the next activity which has the less finish time and the start
    // time is greater than or equal to the previously selected activity. We can do
    // this by sorting the activities according to their finish time and then
    // selecting the activities in order so that the next activity will always have
    // the less finish time. We need to select the next activity such that its start
    // time is greater than or equal to the start time of the previously selected
    // activity.

    Activity[] activities = new Activity[n];

    for (int i = 0; i < n; i++) {
      activities[i] = new Activity(i + 1, start[i], finish[i]);
    }

    // Sort the activities based on their finish time
    Arrays.sort(activities, (o1, o2) -> Integer.compare(o1.finish, o2.finish));

    List<Integer> ans = new ArrayList<>();

    // Add the first activity to the answer
    int i = 0;
    ans.add(activities[i].index);

    // Iterate over all the remaining activities and add only those activities start
    // time of which is greater than or equal to the finish time of previously added
    // activity
    for (int j = 1; j < n; j++) {
      if (activities[j].start >= finish[activities[i].index - 1]) {
        ans.add(activities[j].index);
        i = j;
      }
    }

    System.out.println(Arrays.toString(ans.toArray(new Integer[0])));
  }

  /**
   * Activity instance representing its original index, start time and finish time
   *
   * @author jaymin
   *
   */
  private static class Activity {
    private int index;
    private int start;
    private int finish;

    public Activity(int index, int start, int finish) {
      this.index = index;
      this.start = start;
      this.finish = finish;
    }
  }
}
