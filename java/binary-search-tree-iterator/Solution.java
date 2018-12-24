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
 *
 * Example of iterate a tree:
 *
 * <pre>
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) { TreeNode node = iterator.next(); do something for node }
 * </pre>
 */
public class BSTIterator {
  private Stack<TreeNode> stack = new Stack<>();

  // @param root: The root of binary tree.
  public BSTIterator(TreeNode root) {
    push(root);
  }

  // @return: True if there has next node, or false
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  // @return: return next node
  public TreeNode next() {
    TreeNode node = stack.pop();
    push(node.right);
    return node;
  }

  private void push(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
