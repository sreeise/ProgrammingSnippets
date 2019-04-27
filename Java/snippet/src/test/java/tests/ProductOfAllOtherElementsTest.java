package tests;

import interview_questions.arrays.ProductOfAllOtherElements;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProductOfAllOtherElementsTest {
  @Test
  public void testProduct() {
    int[] products = {3, 4, 5, 6, 7};
    int[] answer = {840, 630, 504, 420, 360};
    int[] result = ProductOfAllOtherElements.product(products);
    int[] result2 = ProductOfAllOtherElements.product2(products);

    assertTrue(result.length > 0);
    assertTrue(result2.length > 0);

    for (int i = 0; i < result.length; i++) {
      assertEquals(result[i], answer[i]);
      assertEquals(result2[i], answer[i]);
    }
  }

  @Test
  public void testProduct2() {
    int[] products = {1, 2, 3, 4, 5};
    int[] answer = {120, 60, 40, 30, 24};
    int[] result = ProductOfAllOtherElements.product(products);
    int[] result2 = ProductOfAllOtherElements.product2(products);

    assertTrue(result.length > 0);
    assertTrue(result2.length > 0);

    for (int i = 0; i < result.length; i++) {
      assertEquals(result[i], answer[i]);
      assertEquals(result2[i], answer[i]);
    }
  }
}
