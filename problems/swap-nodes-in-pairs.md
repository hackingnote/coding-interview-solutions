Swap Nodes in Pairs
===


Problem
-------

[LeetCode 24](https://oj.leetcode.com/problems/swap-nodes-in-pairs/)

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


Code
----

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
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            head.next.next = swapPairs(head.next.next);
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            return tmp;
        }
    }

    public class Solution {
        /**
         * @param head a ListNode
         * @return a ListNode
         */
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            
            ListNode pre = dummy;
            ListNode a = pre.next;
            
            while (a != null && a.next != null) {
                ListNode b = a.next;
                a.next = b.next;
                b.next = a;
                pre.next = b;
                pre = pre.next.next;
                a = pre.next;
            }
            
            return dummy.next;
        }
    }