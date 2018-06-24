# Rotate Image

## Problem

[LeetCode 48](https://oj.leetcode.com/problems/rotate-image/)

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

## Example

Given a matrix

```
[
    [1,2],
    [3,4]
]
```

rotate it by 90 degrees (clockwise), return

```
[
    [3,1],
    [4,2]
]
```

## Challenge

Could you do this in-place?

## Code(Java)

```java
public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }
}
```
