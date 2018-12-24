/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, ArrayList<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }
}
