package interview_questions.arrays;

public class MinimumSwaps {
  /*
   You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
   You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the
   array in ascending order.
   */

  public static int count(int[] array) {
    int swaps = 0;
    boolean[] visited = new boolean[array.length];

    for (int i = 0; i < array.length; i++) {
      int index = i;
      int cycle = 0;

      while (!visited[index]) {
        visited[index] = true;
        index = array[index] - 1;
        cycle++;
      }

      if (cycle != 0) {
        swaps += cycle - 1;
      }
    }

    return swaps;
  }
}
