Reverse Linked List
===

LintCode: https://www.lintcode.com/en/problem/reverse-linked-list-ii/

Problem
-------

Reverse a linked list from position m to n. Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
-------

Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Challenge
---------

Reverse it in-place and in one-pass

Solution
--------

```java
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
    
        
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
        }
        ListNode node = head.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head.next.next;
            head.next.next = tmp;
        }
        
        return dummy.next;
    }
}
```
