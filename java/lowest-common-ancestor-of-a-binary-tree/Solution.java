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
   * @param root: The root of the binary search tree.
   * @param A and B: two nodes in a Binary.
   * @return: Return the least common ancestor(LCA) of the two nodes.
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    if (root == null) {
      return null;
    }
    if (root == A || root == B) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, A, B);
    TreeNode right = lowestCommonAncestor(root.right, A, B);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}
