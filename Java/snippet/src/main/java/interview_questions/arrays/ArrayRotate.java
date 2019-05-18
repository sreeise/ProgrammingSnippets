package interview_questions.arrays;

public class ArrayRotate {
  private ArrayRotate() {
  }

  /**
   * Returns a copy of an int array with its integers rotated to the left a given amount of times.
   *
   * @param array  The array given for rotation
   * @param amount The amount of times to rotate
   * @return Array of int's
   */
  public static int[] left(int[] array, int amount) {
    for (int i = 0; i < amount; i++) {
      int first = array[0];
      array = copy(array);
      array[array.length - 1] = first;
    }
    return array;
  }

  /**
   * Copies an array to a new array starting at position 1. Copied array has the same length.
   *
   * @param array The array to be copied
   * @return Array of int's copied from given array starting at position 1
   */
  private static int[] copy(int[] array) {
    int[] array2 = new int[array.length];
    System.arraycopy(array, 1, array2, 0, array.length - 1);
    return array2;
  }
}
