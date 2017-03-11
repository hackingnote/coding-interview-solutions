Word Break
===


Problem
-------

Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Example
-------

Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

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
    public boolean wordBreak(String s, Set<String> dict) {

        int size = s.length();
        boolean[] flag = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (i == 0 || flag[i - 1] == true) {
                for (int j = i; j < size; j++) {
                    if (dict.contains(s.substring(i, j + 1))) {
                        flag[j] = true;
                    }
                }
            }
        }

        return flag[size - 1];

    }
}

public class Solution {
    /**
     * @param s:    A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        if (len == 0) return true;
        boolean[] flag = new boolean[len];
        flag[0] = true;

        for (int i = 0; i < len; i++) {
            if (flag[i] == false) {
                continue;
            }
            for (String word : dict) {
                int j = i, k = 0, l = word.length();

                while (j < len && k < l && s.charAt(j) == word.charAt(k)) {
                    j++;
                    k++;
                }

                if (k == l) {
                    if (j == len) {
                        return true;
                    } else {
                        flag[j] = true;
                    }
                }
            }
        }
        return false;

    }
}

```