---
title: Move Zeroes
---


Problem
-------



Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Notice

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.


Example
-------

Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].



Solution
--------

```java
public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
       
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
               int j = i;
               while (j >= 1 && nums[j - 1] == 0) j--;
               if (nums[j] == 0) {
                   int tmp = nums[j];
                   nums[j] = nums[i];
                   nums[i] = tmp;
               }
            }
        }
    }
}
```