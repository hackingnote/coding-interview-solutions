House Robber
===


Problem
-------

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example
-------

Given [3, 8, 4], return 8.

Note
---------

Challenge
---------

O(n) time and O(1) memory.

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     *           return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        long rob = A[0];
        long skip = 0;

        for (int i = 1; i < A.length; i++) {
            long tmpRob = skip + A[i];
            long tmpSkip = Math.max(rob, skip);
            skip = tmpSkip;
            rob = tmpRob;
        }

        return Math.max(rob, skip);
    }
}
```