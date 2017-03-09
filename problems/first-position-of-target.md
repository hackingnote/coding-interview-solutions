First Position of Target
===


Problem
-------

For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Example
-------

If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge
---------

If the count of numbers is bigger than 2^32, can your code work properly?

Solution
--------

Code
----

```java
class Solution {
    /**
     * @param nums: The integer array.
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
```