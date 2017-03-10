Container With Most Water
===


Problem
-------

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Example
-------

Given ``[1,3,2]``, the max area of the container is ``2``.

Note
---------

You may not slant the container.

Challenge
---------

Solution
--------



Code(Java)
----------

```java
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int max = 0;
        while (i < j) {
            int height = Math.min(heights[i], heights[j]);
            max = Math.max(max, height * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}

```