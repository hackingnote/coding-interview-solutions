Construct Binary Tree from Inorder and Postorder Traversal
===


Problem
-------

[LeetCode 106](https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


Solution
--------

The last element in postorder is the root, find it in inorder, then the left elements are in left branch, and right elements are in right branch, solve this recursively. For example, the example found in [wikipedia](http://en.wikipedia.org/wiki/Tree_traversal)

    In-order: A, B, C, D, E, F, G, H, I
    Post-order: A, C, E, D, B, H, I, G, F

The root is the last of postorder: F. Find it in inorder: ``ABCDE F GHI``, so ``ABCDE`` are in left branch, ``GHI`` are in right branch.

Key Point
---------

If you are using ``Arrays.copyOfRange(arr, from, to)``, remember ``from`` is inclusive and ``to`` is exclusive...




Code(Java)
----------

```java

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



    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int root = postorder[postorder.length - 1];
        int rootIndex = 0;
        while(inorder[rootIndex] != root) {
            rootIndex++;
        }

        TreeNode rootNode = new TreeNode(root);
        if (postorder.length == 1) {
            return rootNode;
        }
        if (0 > rootIndex - 1) {
            rootNode.left = null;
        } else {
        rootNode.left = buildTree(
            Arrays.copyOfRange(inorder, 0, rootIndex),
            Arrays.copyOfRange(postorder, 0, rootIndex));
        }

        if (rootIndex + 1 > inorder.length - 1  || rootIndex > postorder.length - 2) {
            rootNode.right = null;
        } else {
        rootNode.right = buildTree(
            Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length),
            Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1));

        }
        return rootNode;
    }
}

```