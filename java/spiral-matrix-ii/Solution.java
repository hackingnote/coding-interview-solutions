
public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int i = 0, j = 0, k = 0;
        int num = 1;
        res[0][0] = 1;
        int total = n * n;
        while (num < total) {

            int ti = i + dx[k];
            int tj = j + dy[k];
            if (ti < n && ti >= 0 && tj < n && tj >= 0 && res[ti][tj] == 0) {
                res[ti][tj] = ++num;
                i = ti;
                j = tj;
            } else {
                k = (k + 1) % 4;
            }
        }
        return res;

    }
}