package interview_questions.queues;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QHEAP1 {
  /*
    This question is designed to help you get a better understanding of basic heap operations.
    You will be given queries of types:
    "1 v" - Add an element to the heap.
    "2 v" - Delete the element from the heap.
    "3" - Print the minimum of all the elements in the heap.

    where v is the integer for the given operation.  It is guaranteed that the element to be deleted
    will be there in the heap. Also, at any instant, only distinct elements will be in the heap.

    Conditions:
    The first line contains the number of queries.
    Each of the next lines contains a single query of any one of above 3 mentioned types.
   */

  public static void heap() {
    Scanner scanner = new Scanner(System.in);
    int total = scanner.nextInt();
    int index = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      String[] lines = line.split(" ");
      if (lines.length > 0) {
        if (!lines[0].isEmpty()) {
          int value = Integer.parseInt(lines[0]);

          if (value == 1) {
            queue.add(Integer.parseInt(lines[1]));
          } else if (value == 2) {
            queue.remove(Integer.parseInt(lines[1]));
          } else if (value == 3) {
            System.out.println(queue.peek());
          } else {
            scanner.close();
            return;
          }
        }
      }

      if (index == total) break;
      index += 1;
    }

    scanner.close();
  }
}
