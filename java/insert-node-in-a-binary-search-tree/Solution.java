
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
   * @param node: insert this node into the binary search tree
   * @return: The root of the new binary search tree.
   */
  public TreeNode insertNode(TreeNode root, TreeNode node) {
    if (root == null) {
      return node;
    }
    if (node.val > root.val) {
      if (root.right == null) {
        root.right = node;
      } else {
        insertNode(root.right, node);
      }
    } else if (node.val < root.val) {
      if (root.left == null) {
        root.left = node;
      } else {
        insertNode(root.left, node);
      }
    }

    return root;
  }
}
