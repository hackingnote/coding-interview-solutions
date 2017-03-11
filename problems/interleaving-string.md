Interleaving String
===

## Problem

Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.


## Example

For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


Code(Java)
----------

```java
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] match = new boolean[c1.length + 1][c2.length + 1];

        if (c1.length + c2.length != c3.length) return false;

        match[0][0] = true;
        for (int i = 1; i <= c3.length; i++) {
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                if (j > c1.length || k > c2.length) continue;
                if (j - 1 >= 0 && match[j - 1][k] && c1[j - 1] == c3[i - 1]) {
                    match[j][k] = true;
                }

                if (k - 1 >= 0 && match[j][k - 1] && c2[k - 1] == c3[i - 1]) {
                    match[j][k] = true;
                }
            }
        }
        return match[c1.length][c2.length];
    }
}
```