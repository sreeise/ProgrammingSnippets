package tests;

import data.hashmaps.Pairs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairTest {

  @Test
  static void testPair() {
    int[] array = new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
    assertEquals(Pairs.count(array), 4);
  }
}
