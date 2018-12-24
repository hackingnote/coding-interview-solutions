public class Solution {
  /**
   * @param x the base number
   * @param n the power number
   * @return the result
   */
  public double myPow(double x, int n) {
    double result = 1.0;
    if (n > 0) {
      while (n-- > 0) {
        result *= x;
      }
      return result;
    } else {
      while (n++ < 0) {
        result *= x;
      }
      return 1 / result;
    }
  }
}
