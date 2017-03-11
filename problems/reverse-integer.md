Reverse Integer
===

Problem
-------

Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).

Example
-------

Given x = 123, return 321

Given x = -123, return -321

Note
---------

Challenge
---------

Solution
--------


Code(Java)
----------

```java

public class Solution {

    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        long result = 0;

        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
```