package runtime;

public class O1Runtime {

  private O1Runtime() {}

  // This is O(1) runtime.
  // O(1): AS the size increases, time stays the same. It won't take longer
  // or less time no matter the size of the data_structures.
  // We are always returning the same element, the zeroth element in the array,
  // regardless of the size of data_structures. The size of the array doesn't matter
  // because we only care about 1 element.
  public static void O1(int[] array) {
    System.out.println(array[0]);
  }
}
