Valid Parentheses
===


Problem
-------

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Example
-------

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Note
---------

Challenge
---------

Solution
--------


Code(Java)
----------

```java

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char t = stack.pop();

                if (!(t == '(' && c == ')' ||
                        t == '[' && c == ']' ||
                        t == '{' && c == '}')) {
                    return false;


                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }
}
```