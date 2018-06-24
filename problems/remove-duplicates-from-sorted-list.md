# Remove Duplicates from Sorted List

## Problem

[LeetCode 83](https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/)

Given a sorted linked list, delete all duplicates such that each element appear only once.

## Example

Given `1->1->2`, return `1->2`.

Given `1->1->2->3->3`, return `1->2->3`.

## Code(Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode p = head;
        while (p != null && p.val == head.val) {
            p = p.next;
        }

        head.next = deleteDuplicates(p);

        return head;
    }
}

/**
 * Definition for ListNode
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy;
    }
}
```
