package sort.mergesort;

public class MergeSort {
  public static void sort(int[] array) {
    sort(array, new int[array.length], 0, array.length -1);
  }

  private static void sort(int[] array, int[] temp, int arrayStart, int arrayEnd) {
    if (arrayStart >= arrayEnd) {
      return;
    }

    int middle = getMiddle(arrayStart, arrayEnd);
    sort(array, temp, arrayStart, middle);
    sort(array, temp, middle + 1, arrayEnd);
    merge(array, temp, arrayStart, arrayEnd);
  }

  private static void merge(int[] array, int[] temp, int start, int end) {
    int leftEnd = getMiddle(end, start);
    int rightStart = leftEnd + 1;
    int size = end - start + 1;

    int left = start;
    int right = rightStart;
    int index = start;

    while (left <= leftEnd && right <= end) {
      if (array[left] < array[right]) {
        temp[index] = array[left];
        left++;
      } else {
        temp[index] = array[right];
        right++;
      }
      index++;
    }
    System.arraycopy(array, left, temp, index, leftEnd - left + 1);
    System.arraycopy(array, right, temp, index, end - right + 1);
    System.arraycopy(temp, start, array, start, size);
  }

  private static int getMiddle(int start, int end) {
    return (start + end) / 2;
  }
}
