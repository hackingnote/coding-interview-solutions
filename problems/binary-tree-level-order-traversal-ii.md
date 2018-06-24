# Binary Tree Level Order Traversal II

## Problem

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

## Example

Given binary tree `{3,9,20,#,#,15,7}`,

```
        3
       / \
      9  20
        /  \
       15   7
```

return its bottom-up level order traversal as:

```
    [
      [15,7],
      [9,20],
      [3]
    ]
```

## Code(Java)

```java
/**
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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
