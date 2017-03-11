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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     * using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null) return null;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode dummySame = new ListNode(0);
        ListNode tail1 = dummy1;
        ListNode tail2 = dummy2;
        ListNode tailSame = dummySame;
        ListNode ptr = head.next;

        while (ptr != null) {
            if (ptr.val < head.val) {
                tail1.next = ptr;
                tail1 = tail1.next;
            } else if (ptr.val > head.val) {
                tail2.next = ptr;
                tail2 = tail2.next;
            } else {
                tailSame.next = ptr;
                tailSame = tailSame.next;
            }
            ptr = ptr.next;
        }

        tail1.next = null;
        tail2.next = null;
        tailSame.next = null;

        ListNode left = sortList(dummy1.next);
        ListNode right = sortList(dummy2.next);

        if (dummySame.next != null) {
            head.next = dummySame.next;
            tailSame.next = right;
        } else {
            head.next = right;
        }
        ptr = left;
        while (ptr != null && ptr.next != null) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            return head;
        } else {
            ptr.next = head;
            return left;
        }

    }
}
