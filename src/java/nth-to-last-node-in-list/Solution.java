
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        ListNode a = head;
        ListNode b = head;
        while (n-- > 0) {
            a = a.next;
        }
        while (a != null) {
            a = a.next;
            b = b.next;
        }
        return b;
    }
}
