package interview_questions.linked_lists;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseDoubleLinkedList {

  /*
  You’re given the pointer to the head node of a doubly linked list. Reverse the order of the
  nodes in the list. The head node might be NULL to indicate that the list is empty. Change
  the next and prev pointers of all the nodes so that the direction of the list is reversed.
  Return a reference to the head node of the reversed list.
   */

  /*
  Fastest solution. O(N)

  1. Store a temporary reference to head, called temp, and a node that will store
    the state of head on each swap, called newNode.
  2. while temp is not equal to null
      a. Store a reference to the temp's previous node
      b. Set temp's prev node to temp's next node.
      c. Set temp's next node equal to the stored previous node (Created in a.)
      d. Store the new state in newNode.
      e. Set temp to temp's prev node (Because prev and next are now swapped).
  3. Return newNode.
   */
  public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode temp = head;
    DoublyLinkedListNode newNode = head;
    while (temp != null) {
      DoublyLinkedListNode prev = temp.prev;
      temp.prev = temp.next;
      temp.next = prev;
      newNode = temp;
      temp = temp.prev;
    }

    return newNode;
  }

  /*
  Brute force and slowest Solution. O(N^2)

  Note: This does not necessarily meet the requirements of the question since
  it changes the data within the nodes and not the pointers themselves.

  1. Create a node equal to head to use for looping and storing the data in each node
      of the linked list.
  2. Create an ArrayList<Integer> to store the data in each node of the linked list.
  3. While node is not equal to null
      a. Add the nodes data, node.data, to the array list.
      b. Set last to last's next node.
  4. Use Collections to reverse the array list.
  5. Create a temporary node that is equal to the head node.
  6. Loop through the array list, setting each node's data in the temp node
      equal to the integer int the array list.
  7. Return head.
   */
  public static DoublyLinkedListNode reverseWithCollections(DoublyLinkedListNode head) {
    if (head == null) {
      return null;
    }

    DoublyLinkedListNode node = head;
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (node != null) {
      arrayList.add(node.data);
      node = node.next;
    }

    DoublyLinkedListNode temp = head;
    Collections.reverse(arrayList);
    for (int i : arrayList) {
      temp.data = i;
      temp = temp.next;
    }

    return head;
  }
}
