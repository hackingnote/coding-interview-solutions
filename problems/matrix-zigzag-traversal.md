Matrix Zigzag Traversal
===


Problem
-------

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.

Example
-------

Given a matrix:

    [
      [1, 2,  3,  4],
      [5, 6,  7,  8],
      [9,10, 11, 12]
    ]

return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]

Note
---------

Challenge
---------

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[] result = new int[n * m];
        int t = 0;

        for (int i = 0; i < n + m - 1; i++) {
            if (i % 2 == 1) {
                // down left
                int x = i < m ? 0 : i - m + 1;
                int y = i < m ? i : m - 1;

                while (x < n && y >= 0) {
                    result[t++] = matrix[x++][y--];
                }

            } else {
                // up right

                int x = i < n ? i : n - 1;
                int y = i < n ? 0 : i - n + 1;
                while (x >= 0 && y < m) {
                    result[t++] = matrix[x--][y++];
                }
            }
        }

        return result;
    }
}
```