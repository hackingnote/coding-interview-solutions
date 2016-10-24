Sort Integers
==============

LintCode 463: https://www.lintcode.com/en/problem/sort-integers/

Problem
-------
Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.

Example
-------

Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].

Solution
---------

```java
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j >= 1 && A[j] < A[j - 1]) {
                int tmp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = tmp;
                j--;
            }
        }
    }
}
```