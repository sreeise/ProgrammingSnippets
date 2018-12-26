package runtime;

public class ONRuntime {

  private ONRuntime() {}

  // This will take O(N) time.
  // O(N): The runtime will increase linearly with the size of N.
  // Even though there are two loops the run time is still O(N). However,
  // if the second loop was within the first loop then the runtime would be
  // different - see 0(1).
  public static void ON(int[] array) {
    int sum = 0;
    int product = 1;

    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }

    for (int i = 0; i < array.length; i++) {
      product *= array[i];
    }

    System.out.println(sum + ", " + product);
  }
}
