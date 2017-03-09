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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        search(root, null, result);
        return result;
    }
    
    private void search(TreeNode root, String prefix, List<String> result) {
        if (root == null) {
            return;
        }
        
        String s = (prefix == null ? root.val + "" : prefix + "->" + root.val);
        
        if (root.left == null && root.right == null) {
            result.add(s);
            return;
        } 
        
        if (root.left != null) {
            search(root.left, s, result);
        }
        
        if (root.right != null) {
            search(root.right, s, result);
        }
        
        return;
    }
}
