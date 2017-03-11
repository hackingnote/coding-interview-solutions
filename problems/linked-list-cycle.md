Linked List Cycle
===


Problem
-------

Given a linked list, determine if it has a cycle in it.

Example
-------

Given -21->10->4->5, tail connects to node index 1, return true

Note
---------

Challenge
---------

Follow up:
Can you solve it without using extra space?

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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

```