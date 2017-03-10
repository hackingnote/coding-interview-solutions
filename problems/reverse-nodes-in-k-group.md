Reverse Nodes in k-Group
===

LintCode: http://www.lintcode.com/en/problem/reverse-nodes-in-k-group/

Problem
-------

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Example
-------

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5



Solution
--------

Use the same technique as in "Reverse Linked List II" to reverse partial list.


Code(Java)
----------

```java

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


```