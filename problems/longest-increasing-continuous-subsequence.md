# Longest Increasing Continuous Subsequence

## Problem

Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.

## Example

For `[5, 4, 2, 1, 3]`, the LICS is `[5, 4, 2, 1]`, return `4`.

For `[5, 1, 2, 3, 4]`, the LICS is `[1, 2, 3, 4]`, return `4`.

## Note

`O(n)` time and `O(1)` extra space

## Code(Java)

```java
public class Solution {
    /**
     * @param A an array of Integer
     * @return an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length == 0) return 0;
        int max = 1;
        int cntInc = 1;
        int cntDec = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                cntInc++;
                cntDec = 1;
                max = Math.max(max, cntInc);
            } else if (A[i] < A[i - 1]) {
                cntDec++;
                cntInc = 1;
                max = Math.max(max, cntDec);
            } else {
                cntInc = 1;
                cntDec = 1;
            }
        }
        return max;
    }
}
```
