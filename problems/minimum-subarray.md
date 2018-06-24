# Minimum Subarray

## Problem

Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

## Example

For `[1, -1, -2, 1]`, return `-3`

## Note

The subarray should contain at least one integer.

## Code(Java)

```java
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i : nums) {
            sum += i;
            minSum = Math.min(sum, minSum);
            sum = (sum > 0 ? 0 : sum);
        }
        return minSum;
    }
}
```
