package data_structures.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class Pairs {
  // Get the total pairs for each number in an Integer Array.
  private static HashMap<Integer, Integer> freq(int[] intArr) {
    HashMap<Integer, Integer> frequencies = new HashMap<>();
    for (Integer number : intArr) {
      if (!frequencies.containsKey(number)) {
        frequencies.put(number, 0);
      }
      frequencies.put(number, frequencies.get(number) + 1);
    }
    return frequencies;
  }

  /**
   * Count the number of Integer pairs within an Integer array
   *
   * @param array The array of Integers with possible pairs
   * @return The total amount of pairs
   */
  public static int count(int[] array) {
    int count = 0;
    HashMap<Integer, Integer> map = freq(array);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      Integer number = entry.getKey();

      // We only care about numbers that can have at least 1 pair.
      if (map.get(number) >= 2) {

        // If the frequency of a given number is not even then subtract 1 from
        // the number until it is even. Pairs are counted by 2 of the same number
        // and therefore the total amount of pairs for one number must be even and
        // divisible by 2 such that there is no remainder.
        if (map.get(number) % 2 != 0) {
          while (map.get(number) % 2 != 0) {
            int current = map.get(number) - 1;
            map.put(number, current);
          }
        }

        // If a number is divisible by 2 with a remainder of 0 then the
        // total amount of pairs for a given number will be the amount of
        // times the number is divisible by 2 with a remainder of 0.
        if (map.get(number) % 2 == 0) {
          count += map.get(number) / 2;
        }
      }
    }
    return count;
  }
}
