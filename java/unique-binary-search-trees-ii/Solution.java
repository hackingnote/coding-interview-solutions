/**
 * Definition of TreeNode: public class TreeNode { public int val; public TreeNode left, right;
 * public TreeNode(int val) { this.val = val; this.left = this.right = null; } }
 */
public class Solution {
  /**
   * @paramn n: An integer
   * @return: A list of root
   */
  public List<TreeNode> generateTrees(int n) {

    List<List<TreeNode>> dp = new ArrayList<>();

    List<TreeNode> empty = new ArrayList<>();
    empty.add(null);
    if (n == 0) return empty;

    List<TreeNode> list = new ArrayList<>();
    dp.add(empty);
    dp.add(list);
    dp.get(1).add(new TreeNode(1));

    for (int i = 2; i <= n; i++) {
      List<TreeNode> newList = new ArrayList<>();
      dp.add(newList);
      for (int leftCnt = 0; leftCnt <= i - 1; leftCnt++) {
        int rightCnt = i - 1 - leftCnt;

        List<TreeNode> leftList = dp.get(leftCnt);
        List<TreeNode> rightList = dp.get(rightCnt);
        for (TreeNode left : leftList) {
          for (TreeNode right : rightList) {
            TreeNode root = new TreeNode(leftCnt + 1);
            root.left = copy(left);
            root.right = copy(right);
            updateValue(root.right, leftCnt + 1);
            dp.get(i).add(root);
          }
        }
      }
    }
    return dp.get(n);
  }

  private TreeNode copy(TreeNode node) {
    if (node == null) return null;
    TreeNode newNode = new TreeNode(node.val);
    newNode.left = copy(node.left);
    newNode.right = copy(node.right);
    return newNode;
  }

  private void updateValue(TreeNode node, int plus) {
    if (node == null) return;
    node.val += plus;
    updateValue(node.left, plus);
    updateValue(node.right, plus);
  }
}
