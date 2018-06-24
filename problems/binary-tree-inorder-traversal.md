# Binary Tree Inorder Traversal

## Problem

Given a binary tree, return the inorder traversal of its nodes' values.

## Example

Given binary tree `{1,#,2,3}`,

```
   1
    \
     2
    /
   3
```

return `[1,3,2]`.

## Challenge

Can you do it without recursion?

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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, ArrayList<Integer> result) {

        if (node == null) {
            return;
        }

        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }
}
```
