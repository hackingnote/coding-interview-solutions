
public class Solution {
  /**
   * @param A, B: Two strings.
   * @return: The length of longest common subsequence of A and B.
   */
  public int longestCommonSubsequence(String A, String B) {
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();
    int[][] n = new int[a.length + 1][b.length + 1];

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
          n[i][j] = n[i - 1][j - 1] + 1;
        } else {
          n[i][j] = Math.max(n[i - 1][j], n[i][j - 1]);
        }
      }
    }
    return n[a.length][b.length];
  }
}
