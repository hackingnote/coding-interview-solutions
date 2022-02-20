public class Solution {
  /**
   * @param n non-negative integer, n posts
   * @param k non-negative integer, k colors
   * @return an integer, the total number of ways
   */
  public int numWays(int n, int k) {
    if (n == 1)
      return k;
    if (n == 2)
      return k * k;
    int prev2 = k, prev1 = k * k;
    int current = prev1;
    for (int i = 2; i < n; i++) {
      current = (k - 1) * prev1 + (k - 1) * prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return current;
  }
}
