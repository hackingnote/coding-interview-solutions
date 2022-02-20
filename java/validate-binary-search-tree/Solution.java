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
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  public boolean isValidBST(TreeNode root, double min, double max) {
    if (root == null)
      return true;

    if (root.val >= max || root.val <= min) {
      return false;
    }

    return isValidBST(root.left, min, root.val) &&
        isValidBST(root.right, root.val, max);
  }
}
