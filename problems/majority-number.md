Majority Number
===


Problem
-------

Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Example
-------

Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
---------

O(n) time and O(1) extra space

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int cnt = 0;
        int n = 0;
        for (int i : nums) {
            if (cnt == 0) {
                n = i; 
                cnt++;
            } else if (i == n) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return n;
    }
}

```