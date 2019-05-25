package interview_questions.arrays;

public class BetweenTwoSets {
  /*
  You will be given two arrays of integers and asked to determine all integers that satisfy
  the following two conditions:

    1. The elements of the first array are all factors of the integer being considered
    2. The integer being considered is a factor of all elements of the second array

  These numbers are referred to as being between the two arrays. You must determine how many
  such numbers exist

  Observations:

  1. All numbers in array a evenly divide into a number x if and only if x is divisible by the
     least common multiple (LCD) of all numbers in a.

  2. A number x evenly divides all numbers in array b if and only if x divides the
      greatest common divisor (GCD) of all numbers in b.
   */

  public static int getTotalX(int[] a, int[] b) {
    int gcdOfB = 0;
    for(int i : b) {
      gcdOfB = gcd(gcdOfB, i);
    }

    int lcmOfA = 1;
    for(int i : a) {
      lcmOfA = lcm(lcmOfA, i);
      if (lcmOfA > gcdOfB) {
        return 0;
      }
    }

    if (gcdOfB % lcmOfA != 0) {
      return 0;
    }

    int totalX = 1;
    for (int i = lcmOfA; i < gcdOfB; i++) {
      if (gcdOfB % i == 0 && i % lcmOfA == 0) {
        totalX++;
      }
    }

    return totalX;
  }

  public static int gcd(int a, int b) {
    while (a > 0 && b > 0) {
      if (a >= b) {
        a = a % b;
      } else {
        b = b % a;
      }
    }

    return a + b;
  }

  public static int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
  }
}
