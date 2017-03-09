
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = head;
        head = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return dummy.next;
                }
                tail = tail.next;
            }

            ListNode node = head.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode tmp = head.next;
                head.next = node.next;
                node.next = head.next.next;
                head.next.next = tmp;
            }
            for (int i = 0; i < k; i++) {
                head = head.next;
            }
        }
    }
}

