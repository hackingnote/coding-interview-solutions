Kth Smallest Number in Sorted Matrix
====================================




Problem
-------

Find the kth smallest number in at row and column sorted matrix.

Example
-------

Given k = 4 and a matrix:

    [
      [1 ,5 ,7],
      [3 ,7 ,8],
      [4 ,8 ,9],
    ]
    
return 5

Note
---------

Challenge
---------

O(k log n), n is the maximal number in width and height.

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k:      an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;


        Queue<Node> queue = new PriorityQueue<>(n, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < n; i++) {
            queue.offer(new Node(matrix[i][0], i, 0));
        }

        Node node = null;
        while (k-- > 0) {
            node = queue.poll();
            if (node.col + 1 < m) {
                queue.offer(new Node(matrix[node.row][node.col + 1], node.row, node.col + 1));
            }

        }
        return node.val;
    }

    class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
```