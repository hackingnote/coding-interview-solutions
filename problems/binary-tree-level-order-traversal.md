Binary Tree Level Order Traversal
===


Problem
-------

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Example
-------

Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7
 

return its level order traversal as:

    [
      [3],
      [9,20],
      [15,7]
    ]

Challenge
---------

Challenge 1: Using only 1 queue to implement it.

Challenge 2: Use DFS algorithm to do it.

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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        traverse(root, 0, result);

        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        for (ArrayList<Integer> row : result) {
            stack.push(row);
        }

        result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void traverse(TreeNode node, int level, ArrayList<ArrayList<Integer>> result) {
        if (node == null) return;

        while (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(node.val);

        traverse(node.left, level + 1, result);
        traverse(node.right, level + 1, result);
    }
}

```