Rotate List
====

* [LeetCode 189](https://leetcode.com/problems/rotate-array/)
* [LintCode](http://www.lintcode.com/en/problem/rotate-list/)

Problem
----

Given a list, rotate the list to the right by k places, where k is non-negative.


Example
----

Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.



Code 
----

```java
/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null) return null;
        int size = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        
        k = k % size;
        
        int n = size - k;
        ListNode tmp = dummy;
        
        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }
        
        tail.next = head;
        dummy.next = tmp.next;
        
        tmp.next = null;
        
        return dummy.next;
    }
}
```