# Search in Rotated Sorted Array

## Problem

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

## Example

For `[4, 5, 1, 2, 3]` and target=1, return 2.
For `[4, 5, 1, 2, 3]` and target=0, return -1.

## Solution

Binary search.

- `A[low] < A[mid]`: the left half is monotonically increasing, the "breaking point" is on the right
  - if the target falls in this left half, check left half
  - otherwise check right half
- `A[low] > A[mid]`, or `A[mid] < A[high]`: the right half is monotonically increasing
  - if the target falls in the right half, check right half
  - otherwise check left half

## Code (Python 3)

Note: in Python 3 `i / 2` will return float number. Use `//` to get the integer: `mid = (low + high) // 2`

```python
class Solution:
    """
    @param A: an integer rotated sorted array
    @param target: an integer to be searched
    @return: an integer
    """
    def search(self, A, target):
        # write your code here
        low = 0
        high = len(A) - 1
        while low <= high:
            mid = (low + high) // 2
            if A[mid] == target:
                return mid
            elif A[low] < A[mid]:
                if A[low] <= target and target < A[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if A[mid] < target and target <= A[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
```

## Code (Java)

```java
public class Solution {
    /**
     * @param A      : an integer rotated sorted array
     * @param target :  an integer to be searched
     *               return : an integer
     */
    public int search(int[] A, int target) {
        int low = 0, high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[low] <= A[mid]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
```
