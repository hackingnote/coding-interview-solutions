# Binary Tree Preorder Traversal

## Problem

Given a binary tree, return the preorder traversal of its nodes' values.

## Example

Given:

```
        1
       / \
      2   3
     / \
    4   5
```

return `[1,2,4,5,3]`.

## Challenge

Can you do it without recursion?

## Solution

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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, ArrayList<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }
}
```
