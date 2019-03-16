package tests;

import data_structures.linked_lists.LinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class LinkedListTest<T> {
  @Test
  public void linkedListIntegerTest() {
    LinkedList<Integer> list = new LinkedList<>();
    assertTrue(list.isEmpty());

    list.add(3);
    assertFalse(list.isEmpty());
    assertEquals(Optional.of(list.pop()), Optional.of(3));

    list.add(4);
    list.add(100323243);
    assertEquals(list.size(), 2);
    assertEquals(Optional.of(list.pop()), Optional.of(100323243));
  }

  @Test
  public void linkedListStringTest() {
    LinkedList<String> list = new LinkedList<>();
    assertTrue(list.isEmpty());
    list.add("A String");
    assertFalse(list.isEmpty());
    assertEquals(Optional.of(list.pop()), Optional.of("A String"));

    list.add("String2");
    list.add("String3");
    assertEquals(list.size(), 2);
    assertEquals(Optional.of(list.pop()), Optional.of("String3"));
  }

  @Test
  public void linkedListCharacterTest() {
    LinkedList<Character> list = new LinkedList<>();
    assertTrue(list.isEmpty());
    list.add('A');
    assertFalse(list.isEmpty());
    assertEquals(Optional.of(list.pop()), Optional.of('A'));

    list.add('B');
    list.add('C');
    assertEquals(list.size(), 2);
    assertEquals(Optional.of(list.pop()), Optional.of('C'));
  }

  @Test
  public void linkedListToStringTest() {
    LinkedList<Character> list = new LinkedList<>();
    assertTrue(list.isEmpty());
    list.add('C');
    list.add('B');
    list.add('A');
    assertEquals(list.toString(), "A B C");
  }

  @Test
  public void linkedListToArrayListTest() {
    LinkedList<Character> list = new LinkedList<>();
    assertTrue(list.isEmpty());
    list.add('C');
    list.add('B');
    list.add('A');
    ArrayList<Character> arrayList = new ArrayList<>();
    arrayList.add('A');
    arrayList.add('B');
    arrayList.add('C');
    assertEquals(list.toArrayList(), arrayList);
  }
}
