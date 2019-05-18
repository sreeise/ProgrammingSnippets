package interview_questions.arrays;

public class JumpingOnClouds {
  /*
  For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
  For example, c = [0, 1, 0, 0, 0, 1, 0] indexed from 0 ... 6. The number on each cloud is its index in
  the list so she must avoid the clouds at indexes 1 and 5. She could follow the following two
  paths: 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6. The first path takes 3 jumps while the second takes 4.
  Since the first path only takes 3, the minimum jumps needed is 3.
   */

  static int minimumJumps(int[] c) {
    int count = 0;

    int i = 0;
    while (i < c.length - 1) {
      if (i + 2 >= c.length || c[i + 2] == 1) {
        i = i + 1;
        count = count + 1;
      } else {
        i = i + 2;
        count = count + 1;
      }
    }

    return count;
  }
}
