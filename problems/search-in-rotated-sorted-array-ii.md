Search in Rotated Sorted Array II
===

## Problem

Follow up for Search in Rotated Sorted Array:
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.


## Example

Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
Given [1, 1, 1, 1, 1, 1] and target = 0, return false.

Code(Java)
----------

```java
public class Solution {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {

        if (A.length == 0) return false;
        int low = 0, high = A.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[low] < A[mid]) {
                if (A[low] <= target && target <= A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (A[mid] < A[low]) {
                if (A[mid] <= target  && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return A[low] == target ? true : false;

    }

}

```