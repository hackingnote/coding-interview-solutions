# Minimum Size Subarray Sum

## Problem

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

## Example

Given the array `[2,3,1,2,4,3]` and s = 7, the subarray `[4,3]` has the minimal length under the problem constraint.

## Code(Java)

```java
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s:    an integer
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
        return min != Integer.MAX_VALUE ? min : -1;
    }
}
```
