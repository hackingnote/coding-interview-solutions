/**
 * Definition for binary tree
 *
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    add(result, root, 0);
    for (int i = 0, size = result.size(); i < size / 2; i++) {
      List<Integer> tmp = result.get(i);
      result.set(i, result.get(size - i - 1));
      result.set(size - i - 1, tmp);
    }
    return result;
  }

  private void add(List<List<Integer>> result, TreeNode node, int level) {
    if (node == null) return;
    List<Integer> list;
    if (result.size() <= level) {
      list = new ArrayList<Integer>();
      result.add(list);
    } else {
      list = result.get(level);
    }

    list.add(node.val);
    add(result, node.left, level + 1);
    add(result, node.right, level + 1);
  }
}
