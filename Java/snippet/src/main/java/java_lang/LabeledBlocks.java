package java_lang;

import java.util.Stack;

public class LabeledBlocks {
  /*
  Labeled Blocks are sort of like goto statements. A labeled block can be used
  to in combination with break and continue statements to declare
  a section of code with a specific name that can be used to call
  break and continue on.
   */

  public static Stack<String> labeledBlocks() {
    Stack<String> stack = new Stack<>();
    stack.add("value0");
    stack.add("value01");
    stack.add("value02");
    stack.add("value03");
    stack.add("value04");

    pop:
    while (!stack.isEmpty()) {
      if (stack.get(stack.size() - 1).equals("value01")) {
        break pop;
      }

      stack.pop();
    }

    return stack;
  }
}
