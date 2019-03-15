package tests;

import data_structures.hashsets.Unique;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

public class UniqueWordsTest {
  public static String words = "as d 2#sdaf dasl as as dd l";
  public static final String[] answer = {"as", "d", "2#sdaf", "dasl", "dd", "l"};

  @Test
  public void testUniqueWords() {
    HashSet<String> test = Unique.uniqueWordsHashSet(words);
    for (int i = 0; i < answer.length; i++) {
      assertTrue(test.contains(answer[i]));
    }
  }
}
