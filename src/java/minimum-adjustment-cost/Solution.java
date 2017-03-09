
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int[][] cost = new int[A.size()][101];

        int size = A.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= 100; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i <= 100; i++) {
            cost[0][i] = Math.abs(A.get(0) - i);
        }



        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= 100; j++) {
                int end = Math.min(j + target, 100);
                for (int k = Math.max(0, j - target); k <= end; k++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i - 1][k] + Math.abs(j - A.get(i)));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            min = Math.min(min, cost[size - 1][i]);
        }
        return min;
    }
}