/**
 * Definition of TreeNode:
 *
 * <pre>
 * public class TreeNode {
 *   public int val;
 *   public TreeNode left, right;
 *   public TreeNode(int val) { this.val = val; this.left = this.right = null; }
 * }</pre>
 *
 * Definition for Doubly-ListNode.
 *
 * <pre>
 * public class DoublyListNode {
 *   int val;
 *   DoublyListNode next, prev;
 *   DoublyListNode(int val) { this.val = val; this.next = this.prev = null; }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param root: The root of tree
   * @return: the head of doubly list node
   */
  public DoublyListNode bstToDoublyList(TreeNode root) {
    if (root == null) return null;

    DoublyListNode left = null, right = null;

    if (root.left != null) {
      left = bstToDoublyList(root.left);
    }

    DoublyListNode node = new DoublyListNode(root.val);
    node.prev = rightMost(left);
    if (node.prev != null) {
      node.prev.next = node;
    }
    if (root.right != null) {
      right = bstToDoublyList(root.right);
    }
    node.next = right;
    if (node.next != null) {
      node.next.prev = node;
    }
    return leftMost(node);
  }

  private DoublyListNode leftMost(DoublyListNode node) {
    if (node == null) return null;
    while (node.prev != null) {
      node = node.prev;
    }
    return node;
  }

  private DoublyListNode rightMost(DoublyListNode node) {
    if (node == null) return null;
    while (node.next != null) {
      node = node.next;
    }
    return node;
  }
}
