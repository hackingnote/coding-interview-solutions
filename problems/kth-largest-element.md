# kth Largest Element

## Problem

Find K-th largest element in an array.

## Example

In array `[9,3,2,4,8]`, the 3rd largest element is `4`.

In array `[1,2,3,4,5]`, the 1st largest element is `5`, 2nd largest element is `4`, 3rd largest element is `3` and etc.

## Note

You can swap elements in the array

## Challenge

`O(n)` time, `O(1)` extra memory.

## Solution

QuickSelect

## Code(Java)

```java
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, int[] nums) {
        int m = k - 1;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left == right) return nums[left];
            int n = partition(nums, left, right);
            if (n == m) {
                return nums[n];
            }
            if (n > m) {
                right = n - 1;
            } else {
                left = n + 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = right;
        int k = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[pivot]) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k++;
            }
        }
        int tmp = nums[k];
        nums[k] = nums[pivot];
        nums[pivot] = tmp;
        return k;
    }
}
```
