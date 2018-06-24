# Reverse Words in a String

## Problem

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

## Clarification

- What constitutes a word?

A sequence of non-space characters constitutes a word.

- Could the input string contain leading or trailing spaces?

Yes. However, your reversed string should not contain leading or trailing spaces.

- How about multiple spaces between two words?

Reduce them to a single space in the reversed string.

## Code(Java)

```java
public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int start = 0, end = 0;
        while (end < c.length) {
            while (end < c.length && c[end] != ' ') {
                end++;
            }
            reverse(c, start, end - 1);
            start = end + 1;
            end++;
        }
        reverse(c, 0, c.length - 1);
        return new String(c).trim();
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
    }
}
```
