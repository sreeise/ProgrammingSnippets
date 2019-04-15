package interview_questions.arrays;

public class MinimumSwaps {
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
