package runtime;

public class ON2Runtime {

  private ON2Runtime() {}


  // This is 0(N^2) Runtime.
  // 0(N^2): The runtime is proportionate to the square of the size of data_structures.
  // Here the inner loop with variable j will loop for each value of
  // of the array so it is O(N) and then it does this for every
  // value in the array based upon the outer loop so it becomes O(N^2).
  // Since we are only concerned with the worst case, the O(N^2) becomes
  // the overwhelming factor, thus our algorithm worst case runtime is 0(n^2).
  public static void ON2(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        System.out.println(array[i] + ", " + array[j]);
      }
    }
  }
}
