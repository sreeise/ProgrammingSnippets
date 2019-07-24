package helperfunctions;

import java.util.*;

public class Std {
  public static void printSet(Set<int[]> set) {
    for (int[] s : set) {
      System.out.println(Arrays.toString(s));
    }
  }

  public static void printSortedSet(SortedSet<int[]> set) {
    for (int[] s : set) {
      System.out.println(Arrays.toString(s));
    }
  }

  public static void printList(List<int[]> list) {
    for (int[] s : list) {
      System.out.println(Arrays.toString(s));
    }
  }

  public static void printLists(List<List<Integer>> list) {
    for (List<Integer> s : list) {
      System.out.println(s);
    }
  }

  public static List<Integer> generatePrimes(int n) {
    boolean prime[] = new boolean[n + 1];
    Arrays.fill(prime, true);
    for (int p = 2; p * p <= n; p++) {
      if (prime[p]) {
        for (int i = p * 2; i <= n; i += p) {
          prime[i] = false;
        }
      }
    }

    List<Integer> primeNumbers = new LinkedList<>();
    for (int i = 2; i <= n; i++) {
      if (prime[i]) {
        primeNumbers.add(i);
      }
    }
    return primeNumbers;
  }
}
