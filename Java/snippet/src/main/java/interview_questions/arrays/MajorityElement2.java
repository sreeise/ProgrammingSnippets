package interview_questions.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class MajorityElement2 {
  /*
  Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Note: The algorithm should run in linear time and in O(1) space
   */


  public static List<Integer> majorityElement(int[] array) {
    double times = array.length / 3;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    List<Integer> found = new ArrayList<>();

    for (int i = 0; i < array.length; i++) {
      if (hashMap.containsKey(array[i])) {
        hashMap.put(array[i], hashMap.get(array[i]) + 1);
      } else {
        hashMap.put(array[i], 1);
      }

      if (hashMap.get(array[i]) > times && !found.contains(array[i])) {
        found.add(array[i]);
      }
    }

    return found;
  }


  public static List<Integer> majorityElementSlower(int[] array) {
    Integer[] arr = IntStream.of(array).boxed().toArray(Integer[]::new);
    return majorityElementSlower(arr);
  }

  public static <T> Set<T> convertSlower(T[] array) {
    return new HashSet<>(Arrays.asList(array));
  }

  public static <T extends Integer> List<T> majorityElementSlower(T[] array) {
    List<T> found = new ArrayList<>();
    Set<T> set = MajorityElement2.convertSlower(array);
    double times = array.length / 3;
    List<T> list = Arrays.asList(array);
    for (T s : set) {
      if (!found.contains(s)) {
        int freq = Collections.frequency(list, s);
        if (freq > times) {
          found.add(s);
        }
      }
    }

    return found;
  }

}
