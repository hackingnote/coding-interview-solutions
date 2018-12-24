public class Solution {
  /**
   * @param num: an integer
   * @return: an integer, the number of ones in num
   */
  public int countOnes(int num) {
    int cnt = 0;
    while (num != 0) {
      num &= num - 1;
      cnt++;
    }
    return cnt;
  }
};
