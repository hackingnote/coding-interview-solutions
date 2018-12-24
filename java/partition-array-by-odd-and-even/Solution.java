
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (nums[i] % 2 == 1) i++;
            while (nums[j] % 2 == 0) j--;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}