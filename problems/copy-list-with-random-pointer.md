Copy List with Random Pointer
===


Problem
-------

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Example
-------

Note
---------

Challenge
---------

Could you solve it with O(1) space?

Solution
--------



Code(Java)
----------

```java
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode n = head;
        while (n != null) {
            RandomListNode copy = new RandomListNode(n.label);
            copy.next = n.next;
            n.next = copy;
            n = copy.next;
        }

        n = head;
        while (n != null) {
            if (n.random != null) {
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }

        RandomListNode old = head;
        RandomListNode newHead = head.next;
        n = head.next;
        while (n.next != null) {
            RandomListNode tmp = n.next;
            n.next = n.next.next;
            old.next = tmp;
            old = old.next;
            n = n.next;
        }
        return newHead;
    }
}

```