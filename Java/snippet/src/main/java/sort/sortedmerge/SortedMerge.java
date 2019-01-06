package sort.sortedmerge;

public class SortedMerge {
  /*
  Merges two sorted arrays in sorted order in the first array given that
  it has a large enough buffer.
   */
  public static void merge(int[] a, int[] b, int countA, int countB) {
    int indexMerged = countB + countA - 1;
    int indexA = countA - 1;
    int indexB = countB - 1;

    while (indexB >= 0) {
      if (indexA >= 0 && a[indexA] > b[indexB]) {
        a[indexMerged] = a[indexA];
        indexA--;
      } else {
        a[indexMerged] = b[indexB];
        indexB--;
      }
      indexMerged--;
    }
  }
}
