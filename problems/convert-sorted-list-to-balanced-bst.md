# Convert Sorted List to Balanced BST

## Problem

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

## Example

```
               2
1->2->3  =>   / \
             1   3
```

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
 * Definition of TreeNode:
 * public class TreeNode {
 *   public int val;
 *   public TreeNode left, right;
 *   public TreeNode(int val) {
 *     this.val = val;
 *     this.left = this.right = null;
 *   }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode prev = getMidNode(head);
        ListNode mid = prev.next;
        TreeNode root = new TreeNode(mid.val);
        prev.next = null;
        if (mid != head) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
```
