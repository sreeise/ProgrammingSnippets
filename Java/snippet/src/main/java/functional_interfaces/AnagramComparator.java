package functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2010.%20Sorting%20and%20Searching/Q10_02_Group_Anagrams/AnagramComparator.java
// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2010.%20Sorting%20and%20Searching/Q10_02_Group_Anagrams/QuestionB.java
public class AnagramComparator implements Comparator<String> {
  private static String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  public static void sort(String[] array) {
    HashMapList<String, String> mapList = new HashMapList<>();

    /* Group words by anagram */
    for (String s : array) {
      String key = sortChars(s);
      mapList.put(key, s);
    }

    /* Convert hash table to array */
    int index = 0;
    for (String key : mapList.keySet()) {
      ArrayList<String> list = mapList.get(key);
      for (String t : list) {
        array[index] = t;
        index++;
      }
    }
  }

  public int compare(String s1, String s2) {
    return sortChars(s1).compareTo(sortChars(s2));
  }
}
