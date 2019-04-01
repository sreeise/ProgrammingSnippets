package tests;

import org.junit.Test;
import search.BinarySearch;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
  @Test
  public void binarySearchTest() {
    int[] array = {33, 45, 67, 93, 103, 3434};
    int index = BinarySearch.find(array, 3434);
    assertEquals(5, index);

    int index2 = BinarySearch.recursiveFind(array, 3434, 2, array.length - 1);
    assertEquals(5, index2);

    int[] array2 = new int[100];
    Random random = new Random();
    for (int i = 0; i < array2.length; i++) {
      array2[i] = random.nextInt(100000);
    }

    Arrays.sort(array2);
    int randomInt = random.nextInt(100);
    int num = array2[randomInt];

    int index3 = BinarySearch.find(array2, num);
    assertEquals(num, array2[index3]);
  }
}
