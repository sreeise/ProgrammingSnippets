package interview_questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IceCreamParlor {
  /*
  Given the value of money and the cost of each flavor t for trips to the Ice Cream Parlor,
  help Sunny and Johnny choose two distinct flavors such that they spend their
  entire pool of money during each visit. ID numbers are the 1 based index number
  associated with a. For each trip to the parlor, print the ID numbers for the two
  types of ice cream that Sunny and Johnny purchase as two space-separated integers on
  a new line. You must print the smaller ID first and the larger ID second.


   if money = 5 and cost = [2, 1, 3, 5, 6], then we need to numbers in cost that
   add up to 5 and are not the same number in the array. Therefore, the indexes
   are 0, and 2 because 2 + 3 = 5. The answer is 1, and 3 because 1 is added to
   index to get the ID number.
   */


  // Complete the whatFlavors function below.
  public static void whatFlavors(int[] cost, int money) {
    List<Integer> list = new ArrayList<>();
    for (int j : cost) {
      list.add(j);
    }

    Arrays.sort(cost);
    for (int i = 0; i < cost.length; i++) {
      if (cost[i] < money) {
        int num = Arrays.binarySearch(cost, Math.abs(cost[i] - money));
        if (num >= 0 && num != i) {
          int first = list.indexOf(cost[i]);
          int second = list.indexOf(cost[num]);
          // Both numbers are the same so iterate
          // through the array starting with a counter j = first + 1
          // and find the next index == first and second.
          if (first == second) {
            for (int j = first + 1; j < list.size(); j++) {
              if (list.get(j) == cost[num]) {
                second = j;
                printNums(first, second);
                return;
              }
            }
          }

          printNums(first, second);
          return;
        }
      }
    }
  }

  private static void printNums(int first, int second) {
    if (first <= second) {
      System.out.println((first + 1) + " " + (second + 1));
    } else {
      System.out.println((second + 1) + " " + (first + 1));
    }
  }
}
