package interview_questions.stacks;

import helperfunctions.Std;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Waiter {
  /*
  You are a waiter at a party. There are N stacked plates on pile A0. Each plate has a number written
  on it. Then there will be Q iterations. In i-th iteration, you start picking up the plates in Ai-1 from
  the top one by one and check whether the number written on the plate is divisible by the i-th prime.
  If the number is divisible, you stack that plate on pile Bi. Otherwise, you stack that plate on pile Ai.
  After Q iterations, plates can only be on pil B1, B2, ..., BQ, AQ. Output numbers on these plates from
  top to bottom of each piles in order of B1, B2, ..., BQ, AQ.
   */

  static int[] waiter(int[] number, int q) {
    List<Integer> prime = Std.generatePrimes(9733);
    ArrayList<Stack<Integer>> a = new ArrayList<>();
    ArrayList<Stack<Integer>> b = new ArrayList<>();
    Stack<Integer> aStack = null;
    Stack<Integer> bStack = null;

    for (int i = 0; i <= q; i++) {
      a.add(new Stack<>());
      b.add(new Stack<>());
    }

    Stack<Integer> stack = a.get(0);
    for (int n = 0; n < number.length; n++) {
      stack.push(number[n]);
    }

    for (int i = 1; i <= q; i++) {
      stack = a.get(i - 1);
      while (!stack.isEmpty()) {
        int plate = stack.pop();

        if ((plate % prime.get(i - 1)) == 0) {
          bStack = b.get(i);
          bStack.push(plate);
        } else {
          aStack = a.get(i);
          aStack.push(plate);
        }
      }
    }


    List<Integer> list = new ArrayList<>();
    for (Stack<Integer> integers : b) {
      bStack = integers;
      while (!bStack.isEmpty()) {
        list.add(bStack.pop());
      }
    }

    for (Stack<Integer> integers : a) {
      aStack = integers;
      while (!aStack.isEmpty()) {
        list.add(aStack.pop());
      }
    }

    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }

    return array;
  }
}
