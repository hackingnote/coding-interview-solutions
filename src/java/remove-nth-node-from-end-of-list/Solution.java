
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
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = dummy, b = dummy;
        while (n-- > 0) {
            a = a.next;
        }
        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        b.next = b.next.next;
        return dummy.next;
    }
}
