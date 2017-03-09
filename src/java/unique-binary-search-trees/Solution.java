Unique Binary Search Trees
===


Problem
-------

Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?

Example
-------

Given n = 3, there are a total of 5 unique BST's.

    1           3    3       2      1
     \         /    /       / \      \
      3      2     1       1   3      2
     /      /       \                  \
    2     1          2                  3

Note
---------

Challenge
---------

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @paramn n: An integer
         * @return: An integer
         */
        public int numTrees(int n) {
            int[] cnt = new int[n + 2];
            
            cnt[0] = 1;
            cnt[1] = 1;
            
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= i - 1; j++) {
                    cnt[i] += cnt[j] * cnt[i - 1 - j];
                }
            }
            
            return cnt[n];
        }
    }