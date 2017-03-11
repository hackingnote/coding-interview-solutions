class Solution {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target || (nums[mid] == target && mid > 0 && nums[mid - 1] == target)) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
