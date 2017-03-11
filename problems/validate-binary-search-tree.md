Validate Binary Search Tree
===


Problem
-------

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example
-------

An example:

      2
     / \
    1   4
       / \
      3   5
  
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

Note
---------

Challenge
---------

Solution
--------


Code(Java)
----------

```java

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

    }

    public boolean isValidBST(TreeNode root, double min, double max) {
        if (root == null) return true;

        if (root.val >= max || root.val <= min) {
            return false;
        }


        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
```