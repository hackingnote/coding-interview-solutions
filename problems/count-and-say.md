Count and Say
===

Problem
-------

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.

11 is read off as "two 1s" or 21.

21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Example
-------

Given n = 5, return "111221".


Note
---------

The sequence of integers will be represented as a string.

Challenge
---------

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param n the nth
         * @return the nth sequence
         */
        public String countAndSay(int n) {
            String s = "1";
            while (n-- > 1) {
                char[] c = s.toCharArray();
                String t = "";
                int cnt = 1;
                
                int i = 1;
                while (i <= c.length) {
                    if (i == c.length) {
                        t += cnt + "" + c[i - 1]; 
                    } else if (c[i] == c[i - 1]) {
                        cnt++;
                    } else {
                        t += cnt + "" + c[i - 1];
                        cnt = 1;
                    }
                    i++;
                }
                s = t;
            }
            return s;
        }
    }