Matrix Zigzag Traversal
===

- [LintCode 185](http://www.lintcode.com/en/problem/matrix-zigzag-traversal/)

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

return ``[1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]``



Solution
--------

The example result can be achieved by 6(``m + n - 1``) linear scans:

```
1
2 5
9 6 3
4 7 10
11 8
12
```

Let ``i`` be the number of scans, starting from 0, the even scans are going up-right, while the odd scans are going down-left. The starting point of each scan:

``i % 2 == 0``(up-right): if ``i < m``, there are more rows down below(like ``9`` in the example), start from the first element in row(``matrix[i][0]``) otherwise we've reached the end of ``m`` rows(like ``11`` in the example), so start from the last row but ``i - m + 1`` position(``matrix[m - 1][i - m + 1]``)

```java
int x = i < m ? i : m - 1;
int y = i < m ? 0 : i - m + 1;
```

``i % 2 == 1``(down-left): similar to the up-right case

```java
int x = i < n ? 0 : i - n + 1;
int y = i < n ? i : n - 1;
```

After we find the starting point, we can just keep moving util we reach the edge of the matrix.

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

        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[n * m];
        int t = 0;

        for (int i = 0; i < n + m - 1; i++) {
            if (i % 2 == 1) {
                // down left
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    result[t++] = matrix[x++][y--];
                }
            } else {
                // up right
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    result[t++] = matrix[x--][y++];
                }
            }
        }
        return result;
    }
}
```