/**
 * Definition of SegmentTreeNode:
 *
 * <pre>
 * public class SegmentTreeNode { public int start, end, max; public
 * SegmentTreeNode left, right; public SegmentTreeNode(int start, int end, int
 * max) { this.start = start; this.end = end; this.max = max this.left =
 * this.right = null; } }
 * </pre>
 */
public class Solution {
  /**
   * @param A: a list of integer
   * @return: The root of Segment Tree
   */
  public SegmentTreeNode build(int[] A) {
    if (A.length < 1)
      return null;
    SegmentTreeNode root = build(0, A.length - 1);
    setMax(A, root);
    return root;
  }

  private SegmentTreeNode build(int start, int end) {
    if (start > end) {
      return null;
    }
    SegmentTreeNode node = new SegmentTreeNode(start, end);
    if (start == end) {
      return node;
    }

    node.left = build(start, (start + end) / 2);
    node.right = build((start + end) / 2 + 1, end);

    return node;
  }

  private int setMax(int[] A, SegmentTreeNode node) {
    if (node.start == node.end) {
      node.max = A[node.start];

    } else {
      node.max = Math.max(setMax(A, node.left), setMax(A, node.right));
    }
    return node.max;
  }
}
