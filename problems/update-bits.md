Update Bits
===

## Problem

Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)

 Notice
In the function, the numbers N and M will given in decimal, you should also return a decimal number.



## Example

Given N=(10000000000)2, M=(10101)2, i=2, j=6
return N=(10001010100)2

Code(Java)
----------

```java
class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        
        long mask = (~0L << j + 1L) | ((1L << i) - 1L);
        return (int)((n & mask) | (m << i));
    }
}

```