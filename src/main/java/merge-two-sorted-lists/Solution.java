
/**
 * Definition for ListNode.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int val) {
 * this.val = val;
 * this.next = null;
 * }
 * }
 */
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        if (l1 != null) {
            ptr.next = l1;
        } else if (l2 != null) {
            ptr.next = l2;
        }

        return head.next;
    }
}