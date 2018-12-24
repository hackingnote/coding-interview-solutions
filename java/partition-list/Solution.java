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
   * @param x: an integer
   * @return: a ListNode
   */
  public ListNode partition(ListNode head, int x) {
    ListNode head1 = new ListNode(0);
    ListNode tail1 = head1;
    ListNode head2 = new ListNode(0);
    ListNode tail2 = head2;
    while (head != null) {
      if (head.val < x) {
        tail1.next = head;
        tail1 = tail1.next;
        head = head.next;
        tail1.next = null;
      } else {
        tail2.next = head;
        tail2 = tail2.next;
        head = head.next;
        tail2.next = null;
      }
    }
    tail1.next = head2.next;
    return head1.next;
  }
}
