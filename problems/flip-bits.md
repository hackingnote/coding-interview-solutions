# Flip Bits

- [LintCode 181](http://www.lintcode.com/en/problem/rotate-string/)

## Problem

Determine the number of bits required to flip if you want to convert integer n to integer m.

## Example

Given `n = 31 (11111)`, `m = 14 (01110)`, return `2`.

## Note

Both n and m are 32-bit integers

## Solution

Take XOR of the two numbers, and count how many 1's in it.

## Code(Java)

```java
class Solution {
    /**
     * @param a, b: Two integer
     *           return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int cnt = 0;
        while (c != 0) {
            c &= c - 1;
            cnt++;
        }
        return cnt;
    }
};
```
