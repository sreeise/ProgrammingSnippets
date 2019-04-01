package interview_questions.arrays;

public class LongestConsecutiveSubSequence {
  public static void find(int[] arr) {
    System.out.println("The repeating elements are : ");

    for (int i = 0; i < arr.length; i++) {
      if (arr[Math.abs(arr[i])] >= 0) arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
      else System.out.print(Math.abs(arr[i]) + " ");
    }
  }
}
