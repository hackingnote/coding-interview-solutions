# Longest Common Subsequence

## Problem

Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

## Example

For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

## Clarification

What's the definition of Longest Common Subsequence?

- https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
- http://baike.baidu.com/view/2020307.htm

## Code(Java)

```java
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] n = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    n[i][j] = n[i - 1][j - 1] + 1;
                } else {
                    n[i][j] = Math.max(n[i - 1][j], n[i][j - 1]);
                }
            }
        }
        return n[a.length][b.length];
    }
}
```
