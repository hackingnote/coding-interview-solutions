Maximum Subarray II
===

## Problem

Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

 Notice
The subarray should contain at least one number



## Example

For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

Code(Java)
----------

```java
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        int len = nums.size();

        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        for (int i = 0; i < len; i++) {
            maxLeft[i] = maxRight[i] = Integer.MIN_VALUE;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
            maxLeft[i] = max;
        }

        sum = 0;
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
            maxRight[i] = max;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            result = Math.max(result, maxLeft[i] + maxRight[i + 1]);
        }
        return result;
    }
}


```