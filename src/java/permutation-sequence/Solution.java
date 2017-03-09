Permutation Sequence
===


Problem
-------

* [LeetCode 60](https://oj.leetcode.com/problems/permutation-sequence/)

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.



Code
----

```java
public class Solution {

    private int[] lkp = new int[10];

    private int[] calculate(int n, int k) {
        if (n == 1) {
            int[] result = new int[10];
            result[1] = 1;
            return result;
        }
        int bandwidth = lkp[n] / n;
        Integer current = (int)Math.ceil((double)(k) / bandwidth);

        int remainder = k - (current - 1) * bandwidth;
        int[] result = calculate(n-1, remainder);
        int size = result.length;
        for (int i = 0; i < size; i++) {
            if (result[i] >= current) {
                result[i]++;
            }
        }
        result[n] = current;
        return result;
    }


    public String getPermutation(int n, int k) {

        lkp[1] = 1;

        for (int p = 2; p <= n; p++) {
            lkp[p] = lkp[p-1] * p;
        }

        int[] result = calculate(n, k);
        String s = "";
        for (int i = n; i >= 1; i--) {
           s+=result[i];
        }
        return s;
    }
}
```
