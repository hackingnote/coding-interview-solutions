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
