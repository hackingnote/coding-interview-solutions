Continuous Subarray Sum
===


Problem
-------

Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Example
-------

Give [-3, 1, 3, -3, 4], return [1,4].

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
         * @param A an integer array
         * @return  A list of integers includes the index of the first number and the index of the last number
         */
        public ArrayList<Integer> continuousSubarraySum(int[] A) {
            int sum = 0;
            int start = 0;
            int end = 0;
            int max = Integer.MIN_VALUE;
            int tmpStart = 0;
            int tmpEnd = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
                
                    if (sum > max) {
                        max = sum;
                        end = i;
                        start = tmpStart;
                    }
                
                if (sum < 0) {
                    sum = 0;
                    tmpStart = i + 1;
                    tmpEnd = i + 1;
                }
                
            }
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(start);
            result.add(end);
            return result;
        }
    }