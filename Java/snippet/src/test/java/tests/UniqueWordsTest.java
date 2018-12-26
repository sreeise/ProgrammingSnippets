package tests;

import data.hashsets.Unique;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueWordsTest {
  private static String words = "as d 2#sdaf dasl as as dd l";
  private static final String[] answer = {"as", "d", "2#sdaf", "dasl", "dd", "l"};

  @Test
  static void testUniqueWords() {
    HashSet<String> test = Unique.uniqueWordsHashSet(words);
    for (int i = 0; i < answer.length; i++) {
      assertTrue(test.contains(answer[i]));
    }
  }
}
