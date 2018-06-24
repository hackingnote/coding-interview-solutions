# Single Number

## Problem

Given `2*n + 1` numbers, every numbers occurs twice except one, find it.

## Example

Given `[1,2,2,1,3,4,3]`, return 4

## Note

## Challenge

One-pass, constant extra space.

## Code(Java)

```java
public class Solution {
    /**
     * @param A : an integer array
     *          return : a integer
     */
    public int singleNumber(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int n = A[0];
        for (int i = 1; i < A.length; i++) {
            n = n ^ A[i];
        }

        return n;
    }
}
```
