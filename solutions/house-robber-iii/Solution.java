/**
 * Definition of TreeNode:
 *
 * <pre>
 * public class TreeNode {
 *   public int val;
 *   public TreeNode left, right;
 *
 *   public TreeNode(int x) {
 *     val = x;
 *   }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: The maximum amount of money you can rob tonight
   */
  public int houseRobber3(TreeNode root) {
    int[] dp = search(root);
    return Math.max(dp[0], dp[1]);
  }

  private int[] search(TreeNode root) {
    int[] dp = new int[2];
    if (root == null) {
      return dp;
    }
    int[] left = search(root.left);
    int[] right = search(root.right);

    dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    dp[1] = left[0] + right[0] + root.val;

    return dp;
  }
}
