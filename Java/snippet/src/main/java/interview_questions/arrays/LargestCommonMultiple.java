package interview_questions.arrays;

public class LargestCommonMultiple {
  // Find the LCM of all numbers in an array.

  public static int lcm(int[] array) {
    long num = 1;
    int divisor = 2;

    while (true) {
      int counter = 0;
      boolean divisible = false;

      for (int i = 0; i < array.length; i++) {

        if (array[i] == 0) {
          return 0;
        } else if (array[i] < 0) {
          array[i] = array[i] * (-1);
        }
        if (array[i] == 1) {
          counter++;
        }

        if (array[i] % divisor == 0) {
          divisible = true;
          array[i] = array[i] / divisor;
        }
      }

      if (divisible) {
        num = num * divisor;
      } else {
        divisor++;
      }

      if (counter == array.length) {
        return (int) num;
      }
    }
  }
}
