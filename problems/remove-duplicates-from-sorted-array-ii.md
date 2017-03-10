Remove Duplicates from Sorted Array II
===


Problem
-------

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

Example
-------

Note
---------

Challenge
---------

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        boolean exceeded = false;
        int remember = -1;
        int a = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {

                if (remember == nums[i]) {
                    exceeded = true;
                } else {
                    remember = nums[i];
                    exceeded = false;
                }

                if (exceeded) {
                    continue;
                }
            }
            nums[a++] = nums[i];
        }
        return a;
    }
}
```