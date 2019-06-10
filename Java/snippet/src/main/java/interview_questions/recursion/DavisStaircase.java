package interview_questions.recursion;

public class DavisStaircase {
  /*
  Davis has a number of staircases in his house and he likes to climb each
  staircase 1, 2, or 3 steps at a time. Being a very precocious child, he wonders
  how many ways there are to reach the top of the staircase.

  Must be a recursive solution.
   */
  public static int stepPerms(int n) {
    return stepPerms(n, new int[n + 1]);
  }

  public static int stepPerms(int n, int[] array) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    }
    if (array[n] == 0) {
      array[n] = stepPerms(n - 1, array) + stepPerms(n - 2, array) + stepPerms(n - 3, array);
    }
    return array[n];
  }
}
