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
