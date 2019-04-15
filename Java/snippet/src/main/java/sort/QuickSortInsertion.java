package sort;

/** Quick sort using insertion sort for smaller arrays. */
public class QuickSortInsertion {
  private int[] array;

  public QuickSortInsertion(int[] array) {
    this.array = array;
  }

  public void sort() {
    sort(0, this.array.length - 1);
  }

  public void sort(int left, int right) {
    if (right - left > 0) {
      int pivot = array[right];

      int median = medianOf3(left, right);
      int partition = partition(left, right, median);
      sort(left, partition - 1);
      sort(partition + 1, right);
    }
  }

  private int partition(int left, int right, int pivot) {
    int leftRef = left - 1;
    int rightRef = right;

    while (true) {
      while (true) if (this.array[++leftRef] >= pivot) break;

      while (true) if (rightRef <= 0 || this.array[--rightRef] <= pivot) break;

      if (leftRef >= rightRef) {
        break;
      } else {
        swap(leftRef, rightRef);
      }
    }

    swap(leftRef, right);
    return leftRef;
  }

  private int medianOf3(int left, int right) {
    int center = (left + right) / 2;
    if (array[left] > array[center]) {
      swap(left, center);
    }

    if (array[left] > array[right]) {
      swap(left, right);
    }

    if (array[center] > array[right]) {
      swap(center, right);
    }

    swap(center, right - 1);
    return array[right - 1];
  }

  private void swap(int dex1, int dex2) {
    int temp = this.array[dex1];
    this.array[dex1] = this.array[dex2];
    this.array[dex2] = temp;
  }

  public void insertionSort(int left, int right) {
    for (int out = left + 1; out <= right; out++) {
      int temp = this.array[out];
      int in = out;

      while (in > left && this.array[in - 1] >= temp) {
        this.array[in] = this.array[in - 1];
        --in;
      }
      this.array[in] = temp;
    }
  }
}
