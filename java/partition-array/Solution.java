
public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k:    As description
     *              return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        return j;
    }
}
