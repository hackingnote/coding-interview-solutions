Unique Paths II
===


Problem
-------

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.


Example
-------

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]

The total number of unique paths is 2.

Note
---------

m and n will be at most 100.

Challenge
---------

Solution
--------


Code(Java)
----------

```java

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cnt = new int[m][n];
        cnt[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 || obstacleGrid[i][j] == 1) {
                    continue;
                }
                cnt[i][j] = 0;
                if (i - 1 >= 0 && cnt[i - 1][j] != 0 && obstacleGrid[i - 1][j] == 0) {
                    cnt[i][j] += cnt[i - 1][j];
                }
                if (j - 1 >= 0 && cnt[i][j - 1] != 0 && obstacleGrid[i][j - 1] == 0) {
                    cnt[i][j] += cnt[i][j - 1];
                }
            }
        }
        return cnt[m - 1][n - 1];
    }
}
```