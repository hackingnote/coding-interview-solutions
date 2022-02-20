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
   * @return: buttom-up level order a list of lists of integer
   */
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    traverse(root, 0, result);

    Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
    for (ArrayList<Integer> row : result) {
      stack.push(row);
    }

    result = new ArrayList<>();
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }

    return result;
  }

  private void traverse(TreeNode node, int level,
                        ArrayList<ArrayList<Integer>> result) {
    if (node == null)
      return;

    while (level >= result.size()) {
      result.add(new ArrayList<Integer>());
    }

    result.get(level).add(node.val);

    traverse(node.left, level + 1, result);
    traverse(node.right, level + 1, result);
  }
}
