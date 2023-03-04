public class Solution {
  /**
   * @param nums: a list of integers
   * @return: A integer indicate the sum of minimum subarray
   */
  public int minSubArray(ArrayList<Integer> nums) {
    int minSum = Integer.MAX_VALUE;
    int sum = 0;

    for (int i : nums) {
      sum += i;
      minSum = Math.min(sum, minSum);
      sum = (sum > 0 ? 0 : sum);
    }
    return minSum;
  }
}
