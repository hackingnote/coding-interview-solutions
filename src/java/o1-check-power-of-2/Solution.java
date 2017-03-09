O(1) Check Power of 2
===


Problem
-------

Using O(1) time to check whether an integer n is a power of 2.

Example
-------

For n=4, return true;

For n=5, return false;

Note
---------

Challenge
---------

O(1) time

Solution
--------

Code
----

    #!java
    class Solution {
        /*
         * @param n: An integer
         * @return: True or false
         */
        public boolean checkPowerOf2(int n) {
            long p = (long)n;
            return n != 0 && (p & (p - 1)) == 0;
        }
    };
    