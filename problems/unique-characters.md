# Unique Characters

## Problem

Implement an algorithm to determine if a string has all unique characters.

## Example

Given "abc", return true.

Given "aab", return false.

## Challenge

What if you can not use additional data structures?

## Code(Java)

```java
public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
```
