public class Solution {
  /**
   * @param nums: A list of integers
   * @return: An integer indicate the value of maximum difference between two Subarrays
   */
  public int maxDiffSubArrays(int[] nums) {
    int len = nums.length;

    int[] maxLeft = new int[len];
    int[] minLeft = new int[len];
    int[] maxRight = new int[len];
    int[] minRight = new int[len];

    for (int i = 0; i < len; i++) {
      maxLeft[i] = maxRight[i] = Integer.MIN_VALUE;
      minLeft[i] = minRight[i] = Integer.MAX_VALUE;
    }

    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      max = Math.max(max, sum);
      sum = sum < 0 ? 0 : sum;
      maxLeft[i] = max;
    }
    sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      min = Math.min(min, sum);
      sum = sum > 0 ? 0 : sum;
      minLeft[i] = min;
    }
    sum = 0;
    max = Integer.MIN_VALUE;
    for (int i = len - 1; i >= 0; i--) {
      sum += nums[i];
      max = Math.max(max, sum);
      sum = sum < 0 ? 0 : sum;
      maxRight[i] = max;
    }
    sum = 0;
    min = Integer.MAX_VALUE;
    for (int i = len - 1; i >= 0; i--) {
      sum += nums[i];
      min = Math.min(min, sum);
      sum = sum > 0 ? 0 : sum;
      minRight[i] = min;
    }

    int diff = 0;
    for (int i = 0; i < len - 1; i++) {
      diff = Math.max(diff, Math.abs(maxLeft[i] - minRight[i + 1]));
      diff = Math.max(diff, Math.abs(minLeft[i] - maxRight[i + 1]));
    }
    return diff;
  }
}
