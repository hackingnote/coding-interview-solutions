/**
 * Definition for ListNode.
 *
 * <pre>
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *
 *   ListNode(int val) {
 *     this.val = val;
 *     this.next = null;
 *   }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param head: The first node of linked list.
   * @return: The head of linked list.
   */
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);

    while (head != null) {
      ListNode n = dummy;
      while (n.next != null && n.next.val < head.val)
        n = n.next;
      ListNode next = head.next;
      head.next = n.next;
      n.next = head;
      head = next;
    }

    return dummy.next;
  }
}
