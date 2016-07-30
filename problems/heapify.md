Heapify
===


Problem
-------

Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].

Example
-------

Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Note
---------

Challenge
---------

O(n) time complexity

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param A: Given an integer array
         * @return: void
         */
        public void heapify(int[] A) {
            
            for (int i = A.length - 1; i >= 0; i--) {
                siftDown(A, i);
            }
        }
        
        private void siftDown(int[] a, int k) {
            if (k < a.length) {
                int minIndex = k;
                int left = 2 * k + 1;
                if (left < a.length && a[left] < a[minIndex]) {
                    minIndex = left;
                }
                
                int right = 2 * k + 2;
                if (right < a.length && a[right] < a[minIndex]) {
                    minIndex = right;
                }
                
                if (k != minIndex) {
                    swap(a, minIndex, k);
                    siftDown(a, minIndex);
                }
            }
        }
        
        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
