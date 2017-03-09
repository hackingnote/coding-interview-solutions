/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        
        if (root.left != null) {
            flatten(root.left);
            TreeNode tmpRight = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode t = root.right;
            while (t.right != null) {
                t = t.right;
            }
            t.right = tmpRight;
        }
        flatten(root.right);
    }
}
