Jump Game
===


Problem
-------

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example
-------

A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Note
---------

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

Challenge
---------

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param A: A list of integers
         * @return: The boolean answer
         */
        public boolean canJump(int[] A) {
            int max = 0;
            int i = 0;
            while (i <= max && i < A.length) {
                if (i + A[i] > max) {
                    max = i + A[i];
                }
                i++;
            }
            return max >= A.length - 1;
        }
    }
