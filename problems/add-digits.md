Add Digits
==========



Problem
-------

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example
-------

Given num = 38.
The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 2.

Solution
--------


Code(Java)
----------

```java
public class Solution {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        return 1 + (num - 1) % 9;
    }
}

```