# Length of Last Word

## Problem

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

## Example

Given `s = "Hello World"`, return `5`.

## Note

A word is defined as a character sequence consists of non-space characters only.

## Code(Java)

```java
public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        char[] c = s.trim().toCharArray();
        int i = c.length - 1;
        int len = 0;

        while (i >= 0 && c[i] != ' ') {
            i--;
            len++;
        }
        return len;
    }
}
```
