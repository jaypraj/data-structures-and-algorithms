package org.jaypraj.algorithms.greedy;

import java.util.Scanner;

/**
 * Fractions with 1 in numerator and positive integer in denominator are called
 * unit fractions. Representing any positive fraction with the sum of integer
 * fractions is called the Egyptian fraction.
 *
 * @author jaymin
 *
 */
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

    // Numerator is divisible by the denominator
    if (nr % dr == 0) {
      System.out.println(nr + " / " + dr + " is not a fraction");
      return;
    }

    // Denominator is divisable by the numerator
    if (dr % nr == 0) {
      System.out.print("1 / " + dr / nr);
      return;
    }

    // Numerator is greater than the denominator
    if (nr > dr) {
      System.out.print(nr / dr + " + ");
      printEgyptianFraction(nr % dr, dr);
      return;
    }

    // Denominator is greater than the numerator
    int ceil = dr / nr + 1;
    System.out.print("1 / " + ceil + " + ");
    printEgyptianFraction(nr * ceil - dr, dr * ceil);
  }
}
