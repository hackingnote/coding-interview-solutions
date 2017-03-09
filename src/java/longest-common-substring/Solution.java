
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int[][] cnt = new int[a.length][b.length];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    if (i == 0 || j == 0) {
                        cnt[i][j] = 1;
                    } else {
                        cnt[i][j] = cnt[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, cnt[i][j]);
                }
            }
        }
        return max;
    }
}