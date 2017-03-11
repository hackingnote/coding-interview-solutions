Remove Nth Node From End of List
===


Problem
-------

Given a linked list, remove the nth node from the end of list and return its head.

Example
-------

Given linked list: 1->2->3->4->5->null, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5->null.

Note
---------

The minimum number of nodes in list is n.

Challenge
---------

O(n) time

Solution
--------



Code(Java)
----------

```java

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
     * @param head: The first node of linked list.
     * @param n:    An integer.
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

```