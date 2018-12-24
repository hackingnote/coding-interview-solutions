public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A integer indicate the sum of max subarray
   */
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      maxSum = Math.max(maxSum, sum);
      sum = (sum < 0 ? 0 : sum);
    }
    return maxSum;
  }
}
