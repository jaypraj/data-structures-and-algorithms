package org.jaypraj.algorithms.greedy;

import java.util.Scanner;

public class EgyptianFraction {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int nr = sc.nextInt();
      int dr = sc.nextInt();
      System.out.println("Egyptian fraction representation of " + nr + " / " + dr + ": ");
      printEgyptianFraction(nr, dr);
    }
  }

  private static void printEgyptianFraction(int nr, int dr) {
    if (nr == 0 || dr == 0) return;

    if (nr % dr == 0) {
      System.out.println(nr + " / " + dr + " is not a fraction");
      return;
    }

    if (dr % nr == 0) {
      System.out.print("1 / " + dr / nr);
      return;
    }

    if (nr > dr) {
      System.out.print(nr / dr + " + ");
      printEgyptianFraction(nr % dr, dr);
      return;
    }

    int ceil = dr / nr + 1;
    System.out.print("1 / " + ceil + " + ");
    printEgyptianFraction(nr * ceil - dr, dr * ceil);
  }
}
