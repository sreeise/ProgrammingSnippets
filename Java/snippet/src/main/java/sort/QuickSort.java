package sort;

public class QuickSort {
  private int[] array;
  private int elements;

  public QuickSort(int[] array) {
    this.array = array;
  }

  public void display() {
    System.out.print("A=");
    for (int j = 0; j < this.array.length; j++) System.out.print(array[j] + " ");
    System.out.println();
  }

  public void sort() {
    sort(0, this.array.length - 1);
  }

  public void sort(int left, int right) {
    if (right - left > 0) {
      int pivot = array[right];

      int partition = partition(left, right, pivot);
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

  private void swap(int dex1, int dex2) {
    int temp = this.array[dex1];
    this.array[dex1] = this.array[dex2];
    this.array[dex2] = temp;
  }
}
