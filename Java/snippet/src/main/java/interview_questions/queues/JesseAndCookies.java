package interview_questions.queues;

import java.util.PriorityQueue;

public class JesseAndCookies {
  /*
 Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value K.
 To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special
 combined cookie with:
 sweetness = (1 * Least sweet cookie + 2 * 2nd least sweet cookie).
   */

  static int cookies(int k, int[] array) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int num : array) {
      queue.add(num);
    }

    int operations = 0;
    while (queue.peek() != null && queue.peek() < k) {
      int first = queue.poll();
      if (queue.peek() != null) {
        int second = queue.poll();
        int combine = first + (second * 2);
        queue.add(combine);
        operations += 1;
      } else {
        if (first < k) {
          return -1;
        }

        break;
      }
    }
    return operations;
  }
}
