class Solution {
  /**
   * @param a: The first integer
   * @param b: The second integer
   * @return: The sum of a and b
   */
  public int aplusb(int a, int b) {
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }
};
