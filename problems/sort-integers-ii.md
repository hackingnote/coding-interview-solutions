Sort Integers II
================


Problem
-------

Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.

Example
-------

Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].

Solution
--------

```java
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        if (A.length <= 1) return;
        sort(A, 0, A.length - 1);
    }

    private void sort(int[] A, int lo, int hi) {
        if (lo == hi) return;
        int pivot = A[(lo + hi) / 2];
        int i = lo, j = hi;
        while (i < j) {
            while (A[i] < pivot) i++;
            while (A[j] > pivot) j--;
            if (i <= j) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j--] = tmp;
            }

        }
     
        if (lo < j) {
        sort(A, lo, j);
        }
        if (i < hi) {
        sort(A, i, hi);
        }
    }
}
```