
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
   * @return: True if it has a cycle, or false
   */
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
