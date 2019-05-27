package interview_questions.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
  /*
  The median of a set of integers is the midpoint value of the data set for which an equal number of
  integers are less than and greater than the value. To find the median, you must first sort your set
  of integers in non-decreasing order, then:

      * If your set contains an odd number of elements, the median is the middle element of the sorted sample.
        In the sorted set {1, 2, 3}, 2 is the median.
      * If your set contains an even number of elements, the median is the average of the two middle elements
        of the sorted sample. In the sorted set {1, 2, 3, 4}, 2.5 is the median.

   Given an input stream of integers, you must perform the following task for each
      1. Add the i'th integer to a running list of integers.
      2. Find the median of the updated list (i.e., for the first element through the i'th element).
      3. Print the list's updated median on a new line. The printed value must be a double-precision
         number scaled to decimal place (i.e., 12.3 format).
   */

  public static double[] runningMedian(int[] array) {
    // Puts largest numbers on top and represents a max heap.
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -1 * o1.compareTo(o2));
    // Represents a min heap.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    double[] medians = new double[array.length];
    for (int i = 0; i < array.length; i++) {
      int number = array[i];
      addNumber(number, maxHeap, minHeap);
      balanceHeaps(maxHeap, minHeap);
      medians[i] = getMedian(minHeap, maxHeap);
    }
    return medians;
  }

  private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
    PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

    // If there is an even number of elements then we know that we need to average the
    // elements to get the median.
    if (biggerHeap.size() == smallerHeap.size()) {
      // Average the elements.
      if (biggerHeap.size() == 0) {
        return 0;
      } else {
        return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
      }
    } else {
      // When the heaps have different sizes then we have an odd size of numbers which means
      // the media will be the middle and we dont need to average.
      // This also means that the top element in the bigger heap will be the midpoint or median.
      return biggerHeap.peek();
    }
  }

  private static void addNumber(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    if (minHeap.size() == 0 || number < minHeap.peek()) {
      minHeap.add(number);
    } else {
      maxHeap.add(number);
    }
  }

  // Compare size of two heaps. If off by more then 1 element then shift elements into the bigger
  // size heap.
  private static void balanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
    PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

    // The heaps should be as close in size as possible, or within 1 in size. If their size is off
    // by more than 2 or more then balanceHeaps the heaps.
    if (biggerHeap.size() - smallerHeap.size() >= 2) {
      // Take the top element from the bigger heap and add it to the smaller heap.
      // Priority queue poll gets and removes the top element or the largest element
      // in the bigger heap.
      smallerHeap.add(biggerHeap.poll());
    }
  }
}
