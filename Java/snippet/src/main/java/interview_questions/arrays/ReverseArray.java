package interview_questions.arrays;

public class ReverseArray {
  /*
  Given an array, of integers, print each element in reverse order as a
  single line of space-separated integers and return the reversed array.
  */
  public static int[] reverse(int[] a) {
    int[] b = new int[a.length];
    int length = a.length;
    for (int i = 0; i < a.length; i++) {
      b[length - 1] = a[i];
      length = length - 1;
    }

    // Print the new array which is array a in reverse order.
    for (int i : b) {
      System.out.print(i + " ");
    }

    return b;
  }
}
