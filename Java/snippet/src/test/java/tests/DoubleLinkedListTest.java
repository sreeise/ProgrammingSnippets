package tests;

import data_structures.linked_lists.DoubleLinkedList;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {
  @Test
  public void doubleLinkedListTest() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    assertTrue(linkedList.isEmpty());
    linkedList.add(2);
    linkedList.add(1);
    linkedList.add(10);
    linkedList.add(12);
    assertFalse(linkedList.isEmpty());
    assertEquals(linkedList.size(), 4);
    assertEquals(Optional.of(linkedList.pop()), Optional.of(12));
    assertEquals(Optional.of(linkedList.pop()), Optional.of(10));
    assertEquals(Optional.of(linkedList.pop()), Optional.of(1));
    assertEquals(Optional.of(linkedList.pop()), Optional.of(2));
    assertEquals(linkedList.size(), 0);
    assertTrue(linkedList.isEmpty());
  }
}
