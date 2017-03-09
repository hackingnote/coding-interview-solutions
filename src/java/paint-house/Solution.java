
public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int[][] sum = new int[n][3];
        for (int i = 0; i < 3; i++) {
            sum[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k && sum[i - 1][k] < min) {
                        min = sum[i - 1][k];
                    }
                }
                sum[i][j] = min + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, sum[n - 1][i]);
        }
        return min;
    }
}
