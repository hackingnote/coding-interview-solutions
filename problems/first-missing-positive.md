# First Missing Positive

## Problem

Given an unsorted integer array, find the first missing positive integer.

## Example

Given `[1,2,0]` return 3,
and `[3,4,-1,1]` return 2.

## Code(Java)

```java
public class Solution {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; ) {
            if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1] || A[i] == i + 1) {
                i++;
            } else {
                int s = A[i] - 1;
                int tmp = A[i];
                A[i] = A[s];
                A[s] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }
}
```
