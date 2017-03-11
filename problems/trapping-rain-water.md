Trapping Rain Water
===

## Problem

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



## Example

Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Code(Java)
----------

```java
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int sum = 0;
        int left = 0, right = 0;
        int i = 0, j = heights.length - 1;
        while (i < j) {
            left = Math.max(heights[i], left);
            right = Math.max(heights[j], right);
            if (left < right) {
                sum += left - heights[i];
                i++;
            } else {
                sum += right - heights[j];
                j--;
            }
        }
        return sum;
    }
}
```