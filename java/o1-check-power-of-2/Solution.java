
class Solution {
  /**
   * @param n: An integer
   * @return: True or false
   */
  public boolean checkPowerOf2(int n) {
    long p = (long) n;
    return n != 0 && (p & (p - 1)) == 0;
  }
};
