/**
 * Definition for binary tree
 *
 * <pre>
 * public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 * </pre>
 */
public class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {

    if (postorder.length == 0 || inorder.length == 0) {
      return null;
    }

    int root = postorder[postorder.length - 1];
    int rootIndex = 0;
    while (inorder[rootIndex] != root) {
      rootIndex++;
    }

    TreeNode rootNode = new TreeNode(root);
    if (postorder.length == 1) {
      return rootNode;
    }
    if (0 > rootIndex - 1) {
      rootNode.left = null;
    } else {
      rootNode.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex),
                                Arrays.copyOfRange(postorder, 0, rootIndex));
    }

    if (rootIndex + 1 > inorder.length - 1 ||
        rootIndex > postorder.length - 2) {
      rootNode.right = null;
    } else {
      rootNode.right = buildTree(
          Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length),
          Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1));
    }
    return rootNode;
  }
}
