public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums.length == 0) return -1;
        int start = 0, end = -1, sum = 0, min = Integer.MAX_VALUE;
        while (true) {
            if (sum < s) {
                if (end == nums.length - 1) break;
                sum += nums[++end];
            } else {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
        }
        return min != Integer.MAX_VALUE ?  min:-1;
    }
}