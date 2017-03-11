Median
===


Problem
-------

Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Example
-------

Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5

Note
---------

Challenge
---------

O(n) time.

Solution
--------



Code(Java)
----------

```java

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

```