Count 1 in Binary
===


Problem
-------

Count how many 1 in binary representation of a 32-bit integer.

Example
-------

Given 32, return 1

Given 5, return 2

Given 1023, return 9

Note
---------

Challenge
---------

If the integer is n bits with m 1 bits. Can you do it in O(m) time?

Solution
--------

Code
----

```java
public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        
        int cnt = 0;
        while (num != 0) {
            num &= num - 1;
            cnt++;
        }
        return cnt;
    }
};
```