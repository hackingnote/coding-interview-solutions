Sqrt(x)
===

Sqrt(x)
==================

Problem
-------

Implement int sqrt(int x).

Compute and return the square root of x.

Example
-------

sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Note
---------

Challenge
---------

O(log(x))

Solution
--------

Code
----

    #!java
    class Solution {
        /**
         * @param x: An integer
         * @return: The sqrt of x
         */
        public int sqrt(int x) {
            if (x == 1) return 1;
            long low = 0;
            long high = x;
            while (low < high) {
                long mid = (low + high) / 2;
             
                if (mid * mid <= x) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            return (int)low;
        }
    }