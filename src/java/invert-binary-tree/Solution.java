Invert Binary Tree
===


Problem
-------

Invert a binary tree.

Example
-------

      1         1
     / \       / \
    2   3  => 3   2
       /       \
      4         4
      
Note
---------

Challenge
---------

Do it in recursion is acceptable, can you do it without recursion?

Solution
--------

Code
----

    #!java
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
        public void invertBinaryTree(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
    }