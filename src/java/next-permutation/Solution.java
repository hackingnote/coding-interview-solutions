Next Permutation
===



Problem
-------

* [LeetCode 31](https://oj.leetcode.com/problems/next-permutation/)

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1




Code
----

    #!java
    public class Solution {
        public void nextPermutation(int[] num) {
            int k = num.length - 1;
            while (k - 1 >= 0 && num[k - 1] >= num[k]) {
                k--;
            }

            for (int i = 0; i < (num.length - k) / 2; i++) {
                int tmp = num[k + i];
                num[k + i] = num[num.length - 1 - i];
                num[num.length - 1 - i] = tmp;
            }
            if (k != 0) {
                int i = k;

                while (i < num.length && num[k - 1] >= num[i]) {
                    i++;
                }

                if (i != num.length) {
                    int tmp = num[k - 1];
                    num[k - 1] = num[i];
                    num[i] = tmp;
                }
            }
        }
    }
