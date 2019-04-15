package interview_questions.arrays;

import java.util.HashMap;

public class FruitBaskets {
  /*
    In a row of trees, the i-th tree produces fruit with type tree[i].

  You start at any tree of your choice, then repeatedly perform the following steps:

      Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
      Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.

  Note that you do not have any choice after the initial choice of starting tree: you must perform step 1,
  then step 2, then back to step 1, then step 2, and so on until you stop.

  You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

  What is the total amount of fruit you can collect with this procedure?
     */

  public int totalFruit(int[] tree) {
    int ans = 0, i = 0;
    Counter count = new Counter();
    for (int j = 0; j < tree.length; ++j) {
      count.add(tree[j], 1);
      while (count.size() >= 3) {
        count.add(tree[i], -1);
        if (count.get(tree[i]) == 0) {
          count.remove(tree[i]);
        }
        i++;
      }

      ans = Math.max(ans, j - i + 1);
    }

    return ans;
  }

  class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
      return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
      put(k, get(k) + v);
    }
  }
}
