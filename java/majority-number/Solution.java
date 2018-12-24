
public class Solution {
  /**
   * @param nums: a list of integers
   * @return: find a majority number
   */
  public int majorityNumber(ArrayList<Integer> nums) {
    int cnt = 0;
    int n = 0;
    for (int i : nums) {
      if (cnt == 0) {
        n = i;
        cnt++;
      } else if (i == n) {
        cnt++;
      } else {
        cnt--;
      }
    }
    return n;
  }
}
