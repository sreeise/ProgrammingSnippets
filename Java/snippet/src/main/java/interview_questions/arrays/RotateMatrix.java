package interview_questions.arrays;

// Reference: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_07_Rotate_Matrix/Question.java
public class RotateMatrix {
  /*
  Given an image represented by an NxN matrix, where each pixel in the image
  is 4 bytes, write a method to rotate the image by 90 degrees. Can you do
  this in place?
   */

  public static boolean rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) {
      return false;
    }

    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i]; // save top
        // left to top
        matrix[first][i] = matrix[last - offset][first];
        // bottom to left
        matrix[last - offset][first] = matrix[last][last - offset];
        // right to bottom
        matrix[last][last - offset] = matrix[i][last];
        // top to right
        matrix[i][last] = top; // right <- saved top
      }
    }
    return true;
  }

}
