package data_structures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeBrackets {

  /**
   * Given a string of brackets, such as `{(([])[])[]}[]`, the method checks to see if the the
   * String is a balanced set of brackets.
   *
   * @param String s
   * @return True is the string is balanced else false
   */
  public static boolean isBalanced(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    char current = 0;
    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty()) {
        current = stack.peek();
      }

      stack.push(s.charAt(i));

      if (!stack.isEmpty() && stack.size() > 1) {
        if (shouldPop(current, stack.peek())) {
          stack.pop();
          stack.pop();
        }
      }
    }

    return stack.isEmpty();
  }

  private static boolean shouldPop(char current, char next) {
    switch (current) {
      case '[':
        return next == ']';
      case '{':
        return next == '}';
      case '(':
        return next == ')';
      default:
        return false;
    }
  }
}
