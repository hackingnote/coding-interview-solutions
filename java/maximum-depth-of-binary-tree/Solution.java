
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
   * @return: An integer.
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
