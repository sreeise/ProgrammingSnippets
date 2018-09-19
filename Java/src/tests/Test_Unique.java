package tests;

import data.hashsets.Unique;

import java.util.HashSet;

public class Test_Unique extends AbstractTest {
  private static String words = "as d 2#sdaf dasl as as dd l";
  private static final String[] answer = {"as", "d", "2#sdaf", "dasl", "dd", "l"};

  public static void testUniqueWords() {
    System.out.println("UNIQUE WORDS TEST. CLASS Unique\n");
    setTotalFailed(0);
    setTotalPassed(0);
    System.out.println("Testing String: " + "\"" + words + "\"");

    HashSet<String> test = Unique.uniqueWordsHashSet(words);

    boolean passed = true;

    for (int i = 0; i < answer.length; i++) {
      if (!test.contains(answer[i])) {
        passed = false;
      }
    }

    if (passed) {
      setTotalPassed(getTotalPassed() + 1);
    } else {
      setTotalFailed(getTotalFailed() + 1);
    }

    System.out.println("PASSED: " + getTotalPassed());
    System.out.println("FAILED: " + getTotalFailed());
  }

  public static int[] getTotal() {
    return total();
  }
}
