Symmetric Tree
===

Problem
-------

[LeetCode 101](https://oj.leetcode.com/problems/symmetric-tree/)

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3

But the following is not:

        1
       / \
      2   2
       \   \
       3    3

Code
----

    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return same(root.left, root.right);
        }

        private boolean same(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if ((left == null && right != null) || (left != null && right == null)) return false;
            return left.val == right.val && same(left.left, right.right) && same(left.right, right.left);
        }
    }
