
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int[] cnt = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    cnt[i] = Math.max(cnt[i], cnt[j] + 1);
                    max = Math.max(max, cnt[i]);
                }
            }
        }
        return max;
    }
}
