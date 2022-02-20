public class Solution {

  /**
   * @param n the integer to be reversed
   * @return the reversed integer
   */
  public int reverseInteger(int n) {
    long result = 0;

    while (n != 0) {
      result = result * 10 + n % 10;
      n /= 10;
    }

    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      return 0;
    }

    return (int)result;
  }
}
