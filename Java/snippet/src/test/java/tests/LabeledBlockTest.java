package tests;

import java_lang.LabeledBlocks;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class LabeledBlockTest {
  @Test
  public void labeledBlockTest() {
    Stack<String> stack = LabeledBlocks.labeledBlocks();
    assertEquals(stack.size(), 2);
    assertTrue(stack.contains("value01"));
    assertFalse(stack.contains("value03"));
  }
}
