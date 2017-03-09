Sort Colors 
===========

LintCode 148: http://www.lintcode.com/en/problem/sort-colors/

Problem
-------

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Notice

You are not suppose to use the library's sort function for this problem.
You should do it in-place (sort numbers in the original array).

Example
-------

Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Solution
---------

```java
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