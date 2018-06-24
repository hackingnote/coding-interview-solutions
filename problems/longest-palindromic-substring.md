# Longest Palindromic Substring

## Problem

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

## Example

Given the string = `"abcdzdcab"`, return `"cdzdc"`.

## Code(Java)

```java
public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length * 2 + 3];
        b[0] = '$';
        b[a.length * 2 + 1] = '#';
        b[a.length * 2 + 2] = '&';
        for (int i = 0; i < a.length; i++) {
            b[2 * i + 1] = '#';
            b[2 * i + 2] = a[i];
        }

        int[] p = new int[b.length];
        int index = 1;
        int maxLength = 0;
        for (int i = 2; i < p.length - 2; i++) {
            if (index + p[index] > i) {
                // i's mirror point
                int j = index - (i - index);
                p[i] = Math.min(p[j], index + p[index] - i);
            } else {
                p[i] = 1;
            }

            // matching and extending p[i]
            while (b[i + p[i]] == b[i - p[i]]) p[i]++;

            if (p[i] > p[index]) {
                index = i;
            }
        }

        String result = "";
        for (int i = index - p[index] + 1; i <= index + p[index] - 1; i++) {
            if (b[i] != '#') {
                result += b[i];
            }
        }

        return result;
    }
}
```
