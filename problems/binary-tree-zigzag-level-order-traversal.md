Binary Tree Zigzag Level Order Traversal
===



Problem
-------

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
-------

Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7
 

return its zigzag level order traversal as:

    [
      [3],
      [20,9],
      [15,7]
    ]

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
     * @return: A list of lists of integer include
     * the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        traverse(result, root, 0);

        for (int i = 1; i < result.size(); i += 2) {
            int len = result.get(i).size();
            List<Integer> list = result.get(i);
            for (int j = 0; j < len / 2; j++) {
                int tmp = list.get(j);
                list.set(j, list.get(len - 1 - j));
                list.set(len - 1 - j, tmp);
            }
        }

        return result;

    }

    private void traverse(ArrayList<ArrayList<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        while (result.size() < level + 1) {
            result.add(new ArrayList<Integer>());
        }

        ArrayList<Integer> list = result.get(level);
        list.add(node.val);

        traverse(result, node.left, level + 1);
        traverse(result, node.right, level + 1);

    }
}

```