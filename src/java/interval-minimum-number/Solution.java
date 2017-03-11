/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A,
                                                ArrayList<Interval> queries) {
        Node root = build(A, 0, A.length - 1);

        ArrayList<Integer> result = new ArrayList<>();
        for (Interval q : queries) {
            result.add(query(root, q));
        }
        return result;
    }

    private int query(Node root, Interval query) {
        if (root.start > query.end || root.end < query.start) {
            return Integer.MAX_VALUE;
        }
        if (root.start >= query.start && root.end <= query.end) {
            return root.val;
        }
        return Math.min(query(root.left, query), query(root.right, query));
    }

    private Node build(int[] A, int start, int end) {
        Node node = new Node(start, end, A[start]);
        if (start == end) {
            return node;
        }
        int mid = (start + end) / 2;
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        node.val = Math.min(node.left.val, node.right.val);
        return node;
    }


    class Node {
        int start, end, val;
        Node left, right;
        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}