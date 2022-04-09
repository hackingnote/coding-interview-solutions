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
   * @return: Inorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();

    traverse(root, result);

    return result;
  }

  private void traverse(TreeNode node, ArrayList<Integer> result) {
    if (node == null) {
      return;
    }
    traverse(node.left, result);
    result.add(node.val);
    traverse(node.right, result);
  }
}

// Without Recursion
class Solution2 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    addNodes(stack, root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.add(node.val);
      addNodes(stack, node.right);
    }
    return result;
  }

  private void addNodes(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
