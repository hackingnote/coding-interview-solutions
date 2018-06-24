# Binary Search Tree Iterator

## Problem

Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
`next()` and `hasNext()` queries run in `O(1)` time in average.

## Example

For the following binary search tree, in-order traversal by using iterator is `[1, 6, 10, 11, 12]`

```
   10
 /    \
1      11
 \       \
  6       12
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *   TreeNode node = iterator.next();
 *   do something for node
 * }
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        push(root);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        TreeNode node = stack.pop();
        push(node.right);
        return node;
    }

    private void push(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
```
