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


