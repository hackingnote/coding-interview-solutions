Remove Duplicates from Sorted Array
===

Remove Duplicates from Sorted Array
==================

Problem
-------

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Example
-------

Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

Note
---------

Challenge
---------

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param A: a array of integers
         * @return : return an integer
         */
        public int removeDuplicates(int[] nums) {
            
            int a = 0, b = 0;
            while (b < nums.length) {
                nums[a++] = nums[b++];
                while (b < nums.length && nums[b] == nums[b - 1]) b++;
             
            }
            return a;
        }
    }