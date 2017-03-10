Construct Binary Tree from Preorder and Inorder Traversal
===



Problem
-------

Given preorder and inorder traversal of a tree, construct the binary tree.

Example
-------

Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

      2
     / \
    1   3


Note
---------

You may assume that duplicates do not exist in the tree.

Solution
--------



Code(Java)
----------

```java
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
    
    
  
    private int preIndex = 0;
    
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (preIndex >= preorder.length) {
            return null;
        }
        
        int v = preorder[preIndex++];
        TreeNode node = new TreeNode(v);
        
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == v) break;
        }
        
        if (i > start) {
            node.left = build(preorder, inorder, start, i - 1);
        }
        
        if (i < end) {
            node.right = build(preorder, inorder, i + 1, end);
        }
        
        return node;
        
    }
}

```