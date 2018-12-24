
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
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    int left = minDepth(root.left);
    int right = minDepth(root.right);

    if (left == 0) {
      return right + 1;
    } else if (right == 0) {
      return left + 1;
    } else {
      return Math.min(left, right) + 1;
    }
  }
}
