package interview_questions.arrays;

public class MaxConsecutiveSum {
  public static int maxSubArraySum(int[] array) {
    int size = array.length;
    int max = Integer.MIN_VALUE;
    int temp = 0;

    for (int i = 0; i < size; i++) {
      temp = temp + array[i];
      if (max < temp) {
        max = temp;
      }

      if (temp < 0) {
        temp = 0;
      }
    }
    return max;
  }

  public static int maxSubArraySumSlower(int[] array) {
    int total = Integer.MIN_VALUE;
    int n = array.length;

    for (int i = 0; i < n; i++) {

      for (int j = i; j < n; j++) {
        int temp = 0;
        for (int k = i; k <= j; k++) {
          temp += array[k];
        }
        if (temp > total) {
          total = temp;
        }
      }
    }

    return total;
  }
}
