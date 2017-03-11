Swap Two Nodes in Linked List
===

## Problem

Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, do nothing.

 Notice
You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.



## Example

Given 1->2->3->4->null and v1 = 2, v2 = 4.
Return 1->4->3->2->null.

Code(Java)
----------

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param v2   an integer
     * @return a new head of singly-linked list
     * @oaram v1 an integer
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev1 = dummy;
        ListNode prev2 = dummy;
        while (prev1.next != null && prev1.next.val != v1) prev1 = prev1.next;
        while (prev2.next != null && prev2.next.val != v2) prev2 = prev2.next;
        if (prev1.next == null || prev2.next == null) return dummy.next;

        ListNode node1 = prev1.next;
        ListNode node2 = prev2.next;
        ListNode next1 = node1.next;
        ListNode next2 = node2.next;

        if (next1 == node2) {
            prev1.next = node2;
            node2.next = node1;
            node1.next = next2;
        } else if (next2 == node1) {
            prev2.next = node1;
            node1.next = node2;
            node2.next = next1;

        } else {

            prev1.next = node2;
            prev2.next = node1;

            node2.next = next1;
            node1.next = next2;
        }

        return dummy.next;
    }
}
```