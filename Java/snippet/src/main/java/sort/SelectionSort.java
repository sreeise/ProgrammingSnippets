package sort;

public class SelectionSort {
  public static void sort(int[] array) {
    int length = array.length;

    for (int j = 0; j < length - 1; j++) {
      int iMin = j;

      for (int i = j + 1; i < length; i++) {
        if (array[i] < array[iMin]) {
          iMin = i;
        }
      }

      if (iMin != j) {
        int temp = array[iMin];
        array[iMin] = array[j];
        array[j] = temp;
      }
    }
  }
}
