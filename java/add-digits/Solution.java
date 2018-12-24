public class Solution {
  /**
   * @param num a non-negative integer
   * @return one digit
   */
  public int addDigits(int num) {
    // Write your code here
    return 1 + (num - 1) % 9;
  }
}
