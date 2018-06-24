# Search a 2D Matrix

## Problem

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

## Example

Consider the following matrix:

```
[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
```

Given target = 3, return true.

## Challenge

`O(log(n) + log(m))` time

## Code(Java)

```java
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchRow(matrix, target);
        if (rowIndex == -1) {
            return false;
        }
        return binarySearchElement(matrix[rowIndex], target);
    }

    private int binarySearchRow(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int[] row = matrix[mid];
            if (target < row[0]) {
                end = mid - 1;
            } else if (target > row[row.length - 1]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private boolean binarySearchElement(int[] row, int target) {
        int start = 0, end = row.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < row[mid]) {
                end = mid - 1;
            } else if (target > row[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
```
