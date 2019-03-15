package data_structures.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class Contains {

  // Don't let anyone instantiate this class
  private Contains() {}

  /**
   * Returns the frequency of each word in a String.
   *
   * @param str The string to check frequency of repeated
   *            words.
   * @return HashMap with the frequency of the word and word itself.
   */
  public static HashMap<String, Integer> freq(String[] str) {
    HashMap<String, Integer> frequencies = new HashMap<>();
    for (String word : str) {
      if (!frequencies.containsKey(word)) {
        frequencies.put(word, 0);
      }
      frequencies.put(word, frequencies.get(word) + 1);
    }
    return frequencies;
  }

  /**
   * Gets the frequency of each number in an Integer Array.
   *
   * @param intArr The array for getting frequencies of Integers.
   * @return HashMap with the frequency of the Integer and the Integer itself.
   */
  public static HashMap<Integer, Integer> freq(int[] intArr) {
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
   * Checks to see if the values of the first String array can be found
   * in the second String array.
   * <p>
   * The number of times a word appears also matters in whether the
   * second array contains all the Strings.
   *
   * @param strArr1 String array to check if values can be found in strArr2
   * @param strArr2 String array to check if all values in
   *                can be found from strArr2
   * @return True if all Strings of strArr1 can be found in strArr2 including
   * duplicates, else false
   */
  public static boolean containsAll(String[] strArr1, String[] strArr2) {
    HashMap<String, Integer> strMap1 = freq(strArr1);
    HashMap<String, Integer> strMap2 = freq(strArr2);

    if (strArr2.length < strArr1.length) {
      return false;
    }

    return containsAll(strMap1, strMap2);
  }

  /**
   * Checks if Integer array intArr2 has all values of intArr1
   *
   * @param intArr1 Integer Array values to check for
   * @param intArr2 Integer array values to check against
   * @return True if intArr2 contains all values in intArr1
   */
  public static boolean containsAll(int[] intArr1, int[] intArr2) {
    HashMap<Integer, Integer> intMap1 = freq(intArr1);
    HashMap<Integer, Integer> intMap2 = freq(intArr2);

    if (intArr2.length < intArr1.length) {
      return false;
    }

    return containsAllInts(intMap1, intMap2);
  }

  /**
   * Helper method that checks values and frequency of values in containsAll methods.
   */
  private static boolean containsAllInts(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
    for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
      Integer number = entry.getKey();

      if (!map2.containsKey(number) || map2.get(number) < entry.getValue()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Helper method that checks values and frequency of values in containsAll methods.
   */
  private static boolean containsAll(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
    for (Map.Entry<String, Integer> entry : map1.entrySet()) {
      String word = entry.getKey();

      if (!map2.containsKey(word) || map2.get(word) < entry.getValue()) {
        return false;
      }
    }
    return true;
  }
}
