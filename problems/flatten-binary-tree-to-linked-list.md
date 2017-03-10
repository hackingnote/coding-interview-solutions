Flatten Binary Tree to Linked List
===


Problem
-------

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Example
-------

                  1
                   \
         1          2
        / \          \
       2   5    =>    3
      / \   \          \
     3   4   6          4
                         \
                          5
                           \
                            6
                            
Note
---------

Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Challenge
---------

Do it in-place without any extra memory.

Solution
--------



Code(Java)
----------

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        
        if (root.left != null) {
            flatten(root.left);
            TreeNode tmpRight = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode t = root.right;
            while (t.right != null) {
                t = t.right;
            }
            t.right = tmpRight;
        }
        flatten(root.right);
    }
}

```