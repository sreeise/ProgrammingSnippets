package interview_questions.arrays;

import java.util.List;

public class BirthdayChoclate {
  /*
  Lily has a chocolate bar that she wants to share it with Ron for his birthday. Each of the squares
  has an integer on it. She decides to share a contiguous segment of the bar selected such that the
  length of the segment matches Ron's birth month and the sum of the integers on the squares is equal
  to his birth day. You must determine how many ways she can divide the chocolate.

  Consider the chocolate bar as an array of squares, s = [2, 2, 1, 3, 2]. She wants to find segments
  summing to Ron's birth day d = 4, with a length equalling his birth month, m = 2. In this case,
  there are two segments meeting her criteria: [2, 2] and [1, 3].
   */

  public static int birthday(int[] array, int d, int m) {
    if (array.length == 1) {
      return array[0] == d && m == 1 ? 1 : 0;
    } else if (m > array.length) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (i + m - 1 < array.length) {
        int sum = 0;
        for (int j = i; j <= i + m - 1; j++) {
          sum = sum + array[j];
        }

        if (sum == d) {
          count++;
        }
      }
    }

    return count;
  }

  public static int birthday(List<Integer> s, int d, int m) {
    if (s.size() == 1) {
      return s.contains(d) && m == 1 ? 1 : 0;
    } else if (m > s.size()) {
      return 0;
    } else if (m == 1) {
      return (int) s.stream().filter(i -> i == d).count();
    }

    int count = 0;
    for (int i = 0; i < s.size(); i++) {
      if (i + m < s.size()) {
        if (s.subList(i, i + m).stream().mapToInt(Integer::intValue).sum() == d) {
          count++;
        }
      } else {
        if (s.stream().skip(s.size() - m).mapToInt(Integer::intValue).sum() == d) {
          count++;
        }
        break;
      }
    }

    return count;
  }
}
