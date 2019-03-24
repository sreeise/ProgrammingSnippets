package interview_questions.arrays;

public class HourGlass {
  /*
  Given a 2D Array:
  1 1 1 0 0 0
  0 1 0 0 0 0
  1 1 1 0 0 0
  0 0 0 0 0 0
  0 0 0 0 0 0
  0 0 0 0 0 0

  We define an hourglass in to be a subset of values with indices falling in
  this pattern in an arrays's graphical representation:

  a b c
    d
  e f g

  There are 16 hourglasses in the array, and an hourglass sum is the sum of an hourglass' values.
  Calculate the hourglass sum for every hourglass in the array, then print the maximum hourglass sum.
   */
  private static final int MAX = 6; // size of matrix
  private static final int OFFSET = 2; // hourglass width
  private static int SUM = -63; // initialize to lowest possible sum (-9 x 7)

  private static void hourglass(int[][] matrix, int i, int j) {
    int tmp = 0; // current hourglass sum

    // sum top 3 and bottom 3 elements
    for (int k = j; k <= j + OFFSET; k++) {
      tmp += matrix[i][k];
      tmp += matrix[i + OFFSET][k];
    }

    // sum middle element
    tmp += matrix[i + 1][j + 1];

    if (SUM < tmp) {
      SUM = tmp;
    }
  }

  public static int hourglassSum(int[][] matrix) {
    // find maximum hourglass
    for (int i = 0; i < MAX - OFFSET; i++) {
      for (int j = 0; j < MAX - OFFSET; j++) {
        hourglass(matrix, i, j);
      }
    }

    // return maximum hourglass
    return SUM;
  }
}
