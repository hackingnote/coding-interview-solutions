# Find Peak Element

## Problem

There is an integer array which has the following features:

- The numbers in adjacent positions are different.
- `A[0] < A[1] && A[A.length - 2] > A[A.length - 1]`.

We define a position P is a peek if:

```
A[P] > A[P-1] && A[P] > A[P+1]
```

Find a peak element in this array. Return the index of the peak.

## Example

Given `[1, 2, 1, 3, 4, 5, 7, 6]`

Return index 1 (which is number 2) or 6 (which is number 7)

## Note

The array may contains multiple peeks, find any of them.

## Challenge

Time complexity O(logN)

## Solution

## Code(Java)

```java
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int hi = A.length - 2;
        int lo = 1;

        while (lo <= hi) {
            int mid = (hi + lo) >>> 1;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }

            if (A[mid] < A[mid - 1]) {
                hi = mid - 1;
            } else if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            }
        }
        return 0;
    }
}
```
