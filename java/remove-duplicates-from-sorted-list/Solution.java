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
  public ListNode deleteDuplicates(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode p = head;
    while (p != null && p.val == head.val) {
      p = p.next;
    }

    head.next = deleteDuplicates(p);

    return head;
  }
}


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
   * @return: ListNode head of linked list
   */
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = head;
    while (head != null) {
      while (head.next != null && head.next.val == head.val) {
        head.next = head.next.next;
      }
      head = head.next;
    }
    return dummy;
  }
}
