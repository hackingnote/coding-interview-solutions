Search a 2D Matrix II
===


Problem
-------

Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.

Example
-------

Consider the following matrix:

    [
      [1, 3, 5, 7],
      [2, 4, 7, 8],
      [3, 5, 9, 10]
    ]

Given target = 3, return 2.

Challenge
---------

O(m+n) time and O(1) extra space

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param matrix: A list of lists of integers
         * @param: A number you want to search in the matrix
         * @return: An integer indicate the occurrence of target in the given matrix
         */
        public int searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return 0;
            
            int lenX = matrix.length;
            int lenY = matrix[0].length;
            
            int i = lenX - 1;
            int j = 0;
            int cnt = 0;
            
            while (i >= 0 && j < lenY) {
                if (matrix[i][j] == target) {
                    cnt++;
                    i--;
                } else if (matrix[i][j] < target) {
                    j++;
                } else {
                    i--;
                }
            }
            
            return cnt;
        }
    }

