
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0, right = nums.length - 1;
    
        for (int i = 0; i <= right;) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left++] = 0;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right--] = 2; 
            } else {
                i++;
            }
        }
    }
}
```