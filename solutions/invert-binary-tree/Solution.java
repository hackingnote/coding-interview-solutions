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
   * @param root: a TreeNode, the root of the binary tree
   * @return: nothing
   */
  public void invertBinaryTree(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertBinaryTree(root.left);
    invertBinaryTree(root.right);
  }
}
