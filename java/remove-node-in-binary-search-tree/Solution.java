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
   * @param value: Remove the node with given value.
   * @return: The root of the binary search tree after removal.
   */
  public TreeNode removeNode(TreeNode root, int value) {
    TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
    dummy.left = root;

    TreeNode node = dummy;
    while (true) {
      if (node == null)
        break;

      if (node.left != null && node.left.val == value) {
        remove(node, true);
        break;
      } else if (node.right != null && node.right.val == value) {
        remove(node, false);
        break;
      } else {
        if (value < node.val)
          node = node.left;
        else
          node = node.right;
      }
    }

    return dummy.left;
  }

  private void remove(TreeNode parent, boolean isLeft) {
    TreeNode target = isLeft ? parent.left : parent.right;

    if (target.left == null && target.right == null) {
      if (isLeft)
        parent.left = null;
      else
        parent.right = null;
    } else if (target.left != null && target.right == null) {
      if (isLeft)
        parent.left = target.left;
      else
        parent.right = target.left;
    } else if (target.left == null && target.right != null) {
      if (isLeft)
        parent.left = target.right;
      else
        parent.right = target.right;
    } else {
      if (target.left.left == null && target.left.right == null) {
        target.val = target.left.val;
        target.left = null;
      } else {
        // inorder
        TreeNode newParent = target.left;
        while (newParent.right.right != null) {
          newParent = newParent.right;
        }
        target.val = newParent.right.val;
        remove(newParent, false);
      }
    }
  }
}
