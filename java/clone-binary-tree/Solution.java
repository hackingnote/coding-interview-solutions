/**
 * Definition of TreeNode:
 *
 * <pre>
 * public class TreeNode {
 *   public int val;
 *   public TreeNode left, right;
 * 
 *   public TreeNode(int val) {
 *     this.val = val;
 *     this.left = this.right = null;
 *   }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param root: The root of binary tree
   * @return root of new tree
   */
  public TreeNode cloneTree(TreeNode root) {
    if (root == null) return null;
    TreeNode newNode = new TreeNode(root.val);
    newNode.left = cloneTree(root.left);
    newNode.right = cloneTree(root.right);
    return newNode;
  }
}
