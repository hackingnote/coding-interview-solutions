# Convert Sorted Array to Binary Search Tree With Minimal Height

## Problem

Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.

## Example

Given `[1,2,3,4,5,6,7]`, return

```
         4
       /   \
      2     6
     / \    / \
    1   3  5   7
```

## Note

There may exist multiple valid solutions, return any of them.

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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A.length == 0) {
            return null;
        }

        if (A.length == 1) {
            return new TreeNode(A[0]);
        }

        int mid = (A.length + 1) / 2 - 1;
        TreeNode node = new TreeNode(A[mid]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(A, 0, mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(A, mid + 1, A.length));

        return node;
    }
}
```
