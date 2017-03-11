Rotate String
===


Problem
-------

Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
-------

Given "abcdefg".

    offset=0 => "abcdefg"
    offset=1 => "gabcdef"
    offset=2 => "fgabcde"
    offset=3 => "efgabcd

Challenge
---------

Rotate in-place with O(1) extra memory.


Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param str:    an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str.length == 0) {
            return;
        }

        offset = offset % str.length;

        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
```