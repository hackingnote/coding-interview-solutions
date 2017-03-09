
public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        int[] cnt = new int[n + 2];

        cnt[0] = 1;
        cnt[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                cnt[i] += cnt[j] * cnt[i - 1 - j];
            }
        }

        return cnt[n];
    }
}