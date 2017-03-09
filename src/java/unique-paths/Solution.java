
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        int[][] cnt = new int[m][n];
        for (int i = 0; i < n; i++) {
            cnt[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            cnt[i][0] = 1;
            for (int j = 1; j < n; j++) {
                cnt[i][j] = cnt[i - 1][j] + cnt[i][j - 1];
            }
        }
        return cnt[m - 1][n - 1];
    }
}
