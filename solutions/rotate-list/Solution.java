/**
 * Definition for singly-linked list.
 *
 * <pre>
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param head: the List
   * @param k: rotate to the right k places
   * @return: the list after rotation
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    int size = 0;
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode tail = dummy;
    while (tail.next != null) {
      tail = tail.next;
      size++;
    }

    k = k % size;
    int n = size - k;
    ListNode tmp = dummy;
    for (int i = 0; i < n; i++) {
      tmp = tmp.next;
    }
    tail.next = head;
    dummy.next = tmp.next;
    tmp.next = null;
    return dummy.next;
  }
}
