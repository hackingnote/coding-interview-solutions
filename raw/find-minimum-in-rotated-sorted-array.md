Find Minimum in Rotated Sorted Array
===


Problem
-------

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

Example
-------

Given [4, 5, 6, 7, 0, 1, 2] return 0

Note
---------

You may assume no duplicate exists in the array.

Challenge
---------

Solution
--------

Code
----

```java
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        
        
        int low = 0;
        int high = num.length - 1;
        
        while(num[low] > num[high]) {
            if (low == high - 1) {
                return num[high];
            }
            int mid = (low + high) / 2;
            if (num[low] < num[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return num[low];
    }
}
```