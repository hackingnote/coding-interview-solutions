Binary Tree Maximum Path Sum
===



Problem
-------

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example
-------
Given the below binary tree:

      1
     / \
    2   3

return 6.


Note
---------

Challenge
---------

Solution
--------

Code
----

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
    private int max = Integer.MIN_VALUE;
    
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    
    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        max = Math.max(max, left + right + root.val);
        max = Math.max(max, root.val);
        return Math.max(left, right) + root.val;
    }
}
```