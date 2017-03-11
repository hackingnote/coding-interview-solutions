/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
         ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    while (p.next != null) {
        if (p.next.next != null && p.next.val == p.next.next.val) {
            int val = p.next.val;
            while (p.next != null && p.next.val == val) {
                p.next = p.next.next;
            }
        } else {
            p = p.next;
        }
        
    }
    return dummy.next;
    }
}
