# Interleaving Positive and Negative Numbers

## Problem

Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

## Example

Given `[-1, -2, -3, 4, 5, 6]`, after re-range, it will be `[-1, 5, -2, 4, -3, 6]` or any other reasonable answer.

## Note

You are not necessary to keep the original order of positive integers or negative integers.

## Challenge

Do it in-place and without extra memory.

## Code(Java)

```java
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        int cntPos = 0;
        for (int i : A) {
            if (i > 0) cntPos++;
        }

        if (cntPos > A.length - cntPos) {
            // even: pos, odd: neg
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                while (A[i] > 0 && i + 2 < A.length) i += 2;
                while (A[j] < 0 && j + 2 < A.length) j += 2;
                if (A[i] < 0 && A[j] > 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
                i += 2;
                j += 2;
            }
        } else {
            // even: neg, odd: pos
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                while (A[i] < 0 && i + 2 < A.length) i += 2;
                while (A[j] > 0 && j + 2 < A.length) j += 2;
                if (A[i] > 0 && A[j] < 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
                i += 2;
                j += 2;
            }
        }
    }
}
```
