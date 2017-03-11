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
     * @param root   the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        LinkedList<Integer> buffer = new LinkedList<>();
        buffer.add(root.val);
        search(result, buffer, root, target);
        return result;
    }

    private void search(List<List<Integer>> result, LinkedList<Integer> buffer, TreeNode node, int target) {
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (int i : buffer) {
                sum += i;
            }
            if (sum == target) {
                result.add(new ArrayList<Integer>(buffer));
            }
            return;
        }

        if (node.left != null) {

            buffer.add(node.left.val);
            search(result, buffer, node.left, target);
            buffer.removeLast();
        }

        if (node.right != null) {

            buffer.add(node.right.val);
            search(result, buffer, node.right, target);
            buffer.removeLast();
        }
    }
}