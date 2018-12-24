/**
 * Definition for ListNode
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
   * @param ListNode head is the head of the linked list
   * @oaram m and n
   * @return: The head of the reversed ListNode
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    // write your code
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;

    for (int i = 0; i < m - 1; i++) {
      head = head.next;
    }
    ListNode node = head.next;
    for (int i = 0; i < n - m; i++) {
      ListNode tmp = head.next;
      head.next = node.next;
      node.next = head.next.next;
      head.next.next = tmp;
    }

    return dummy.next;
  }
}
