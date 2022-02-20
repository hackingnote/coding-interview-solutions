/**
 * Definition of Interval:
 *
 * <pre>
 * public class Interval {
 * int start, end;
 * Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }}
 * </pre>
 */
public class Solution {
  /**
   * @param A, queries: Given an integer array and an query list
   * @return: The result list
   */
  public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
    Node root = buildTree(A, 0, A.length - 1);
    ArrayList<Long> result = new ArrayList<>();
    for (Interval q : queries) {
      result.add(query(root, q));
    }
    return result;
  }

  private long query(Node root, Interval query) {
    if (root == null)
      return 0;

    if (root.start >= query.start && root.end <= query.end) {
      return root.sum;
    }
    long left = query(root.left, query);
    long right = query(root.right, query);
    return left + right;
  }

  private Node buildTree(int[] A, int start, int end) {
    if (start > end)
      return null;
    if (start == end)
      return new Node(start, end, A[start]);
    int mid = (start + end) / 2;
    Node left = buildTree(A, start, mid);
    Node right = buildTree(A, mid + 1, end);
    Node root = new Node(start, end, left.sum + right.sum);
    root.left = left;
    root.right = right;
    return root;
  }

  class Node {
    int start, end;
    long sum;
    Node left, right;

    public Node(int start, int end, long sum) {
      this.start = start;
      this.end = end;
      this.sum = sum;
    }
  }
}
