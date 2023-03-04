/**
 * Definition for binary tree
 *
 * <pre>
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *
 *   TreeNode(int x) {
 *     val = x;
 *   }
 * }
 * </pre>
 */
public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if ((p == null && q != null) || (p != null && q == null)) return false;
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
