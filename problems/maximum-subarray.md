Maximum Subarray
===


Problem
-------

Given an array of integers, find a contiguous subarray which has the largest sum.

Example
-------

Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Note
----

The subarray should contain at least one number.

Challenge
---------

Can you do it in time complexity O(n)?

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param nums: A list of integers
         * @return: A integer indicate the sum of max subarray
         */
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                maxSum = Math.max(maxSum, sum);
                sum = (sum < 0 ? 0 : sum);
            }
            
            return maxSum;
        }
    }
