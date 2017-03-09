
public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
       
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
               int j = i;
               while (j >= 1 && nums[j - 1] == 0) j--;
               if (nums[j] == 0) {
                   int tmp = nums[j];
                   nums[j] = nums[i];
                   nums[i] = tmp;
               }
            }
        }
    }
}
