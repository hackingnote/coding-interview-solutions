# Find Minimum in Rotated Sorted Array II

## Problem

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).
Find the minimum element.

Notice

The array may contain duplicates.

## Example

Given `[4,4,5,6,7,0,1,2]` return `0`.

## Code(Java)

```java
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int low = 0, high = num.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (num[mid] > num[high]) {
                low = mid + 1;
            } else if (num[mid] < num[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return num[low];
    }
}
```
