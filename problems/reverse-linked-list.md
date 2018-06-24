# Reverse Linked List

LintCode: https://www.lintcode.com/en/problem/reverse-linked-list/

## Problem

Reverse a linked list.

## Example

For linked list `1->2->3`, the reversed linked list is `3->2->1`

## Challenge

Reverse it in-place and in one-pass

## Code(Java)

```java
/**
 * Definition for ListNode.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int val) {
 *     this.val = val;
 *     this.next = null;
 *   }
 * }
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode a = null;
        ListNode b = head;

        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}
```
