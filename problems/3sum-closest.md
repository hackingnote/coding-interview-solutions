3Sum Closest
============

Problem
-------

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Example
-------

For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Note
---------

You may assume that each input would have exactly one solution.

Challenge
---------

O(n^2) time, O(1) extra space

Solution
--------


Code(Java)
----------

```java
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target   : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                int s = numbers[i] + numbers[left] + numbers[right];
                if (Math.abs(s - target) < min) {
                    min = Math.abs(s - target);
                    sum = s;
                }

                if (s < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }
}

```