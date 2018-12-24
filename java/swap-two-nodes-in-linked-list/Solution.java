/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
public class Solution {
  /**
   * @param head a ListNode
   * @param v2 an integer
   * @return a new head of singly-linked list
   * @oaram v1 an integer
   */
  public ListNode swapNodes(ListNode head, int v1, int v2) {
    // Write your code here
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev1 = dummy;
    ListNode prev2 = dummy;
    while (prev1.next != null && prev1.next.val != v1) prev1 = prev1.next;
    while (prev2.next != null && prev2.next.val != v2) prev2 = prev2.next;
    if (prev1.next == null || prev2.next == null) return dummy.next;

    ListNode node1 = prev1.next;
    ListNode node2 = prev2.next;
    ListNode next1 = node1.next;
    ListNode next2 = node2.next;

    if (next1 == node2) {
      prev1.next = node2;
      node2.next = node1;
      node1.next = next2;
    } else if (next2 == node1) {
      prev2.next = node1;
      node1.next = node2;
      node2.next = next1;

    } else {

      prev1.next = node2;
      prev2.next = node1;

      node2.next = next1;
      node1.next = next2;
    }

    return dummy.next;
  }
}
