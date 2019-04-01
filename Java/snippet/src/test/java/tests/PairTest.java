package tests;

import data_structures.hashmaps.Pairs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairTest {

  @Test
  public void testPair() {
    int[] array = new int[] {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
    assertEquals(Pairs.count(array), 4);
  }
}
