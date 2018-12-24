
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        int m = (nums.length - 1) / 2;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left == right) return nums[left];
            int n = partition(nums, left, right);
            if (n == m) {
                return nums[n];
            }
            if (n > m) {
                right = n - 1;
            } else {
                left = n + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = right;
        int k = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[pivot]) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k++;
            }
        }
        int tmp = nums[k];
        nums[k] = nums[pivot];
        nums[pivot] = tmp;
        return k;
    }


}
