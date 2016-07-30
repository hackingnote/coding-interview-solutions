Majority Number
===


Problem
-------

Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

Example
-------

Given [1, 2, 1, 2, 1, 3, 3], return 1.

Note
----

There is only one majority number in the array.

Challenge
---------

O(n) time and O(1) extra space.

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param nums: A list of integers
         * @return: The majority number that occurs more than 1/3
         */
        public int majorityNumber(ArrayList<Integer> nums) {
            int cnt1 = 0;
            int cnt2 = 0;
            int num1 = 0;
            int num2 = 0;
            
            for (int n : nums) {
                if (cnt1 == 0) {
                    num1 = n;
                    cnt1++;
                } else if (n == num1) {
                    cnt1++;
                } else if (cnt2 == 0) {
                    num2 = n;
                    cnt2++;
                } else if (n == num2) {
                    cnt2++;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
            
            int cnt = 0;
            for (int n : nums) {
                if (n == num1) {
                    cnt++;
                }
            }
            return (cnt > nums.size() / 3 ? num1 : num2);
        }
    }
