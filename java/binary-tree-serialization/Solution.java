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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> parts = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                parts.add("#");
            } else {
                parts.add(node.val + "");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        int size = parts.size();
        String result = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                result += parts.get(i);
            } else {
                result += "," + parts.get(i);
            }
        }
        return result;

    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] parts = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        queue.offer(root);
        int i = 1;
        while (i < parts.length) {
            TreeNode node = queue.poll();

            if (parts[i].equals("#")) {
                node.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                node.left = left;
                queue.offer(left);
            }

            if (i + 1 == parts.length) break;

            if (parts[i + 1].equals("#")) {
                node.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i + 1]));
                node.right = right;
                queue.offer(right);
            }
            i += 2;
        }
        return root;
    }
}

