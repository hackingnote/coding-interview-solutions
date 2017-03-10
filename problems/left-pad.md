---
title: Left Pad
---


LintCode 524: https://www.lintcode.com/en/problem/left-pad/

Problem
-------



You know what, left pad is javascript package and referenced by React:
Github link

One day his author unpublished it, then a lot of javascript projects in the world broken.

You can see from github it's only 11 lines.

You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.

Example
-------

```javascript
leftpad("foo", 5)
>> "  foo"

leftpad("foobar", 6)
>> "foobar"

leftpad("1", 2, "0")
>> "01"
```




Code(Java)
----------

```java

public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        int len = originalStr.length();
        if (len >= size) return originalStr;
        return new String(new char[size - len]).replace("\0", String.valueOf(padChar)) + originalStr;
    }
}

```