public class Solution {
  /**
   * @param n: An integer
   * @return: An integer
   */
  public int climbStairs(int n) {
    int a = 1, b = 1;
    while (n-- > 0) {
      int c = a + b;
      a = b;
      b = c;
    }
    return a;
  }
}
