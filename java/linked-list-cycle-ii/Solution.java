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
   * @return: The node where the cycle begins. if there is no cycle, return null
   */
  public ListNode detectCycle(ListNode head) {
    // write your code here
    if (head == null)
      return null;
    ListNode fast = head, slow = head;
    int cnt = 0;
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast.next == null)
        return null;
      fast = fast.next;
      if (slow == fast) {
        slow = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }
        return fast;
      }
    }
    return null;
  }
}
