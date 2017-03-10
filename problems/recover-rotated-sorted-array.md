Recover Rotated Sorted Array
===

Problem
-------

Given a rotated sorted array, recover it to sorted array in-place.

Example
-------

    [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
---------

In-place, O(1) extra space and O(n) time.

Clarification
-------------

What is rotated array?

For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int size = nums.size();
        int i;
        for (i = 1; i < size; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                break;
            }
        }

        reverse(nums, 0, i - 1);
        reverse(nums, i, size - 1);
        reverse(nums, 0, size - 1);
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
            i++;
            j--;
        }
    }
}
```