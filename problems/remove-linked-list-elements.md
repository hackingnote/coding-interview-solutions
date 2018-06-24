# Remove Linked List Elements

## Problem

Remove all elements from a linked list of integers that have value val.

## Example

Given `1->2->3->3->4->5->3`, val = 3, you should return the list as `1->2->4->5`

## Code(Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val  an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode b = a;
        ListNode c = a;
        while (c.next != null) {
            c = c.next;
            if (c.val == val) {
                b.next = c.next;
            } else {
                b = b.next;
            }
        }
        return a.next;
    }
}
```
