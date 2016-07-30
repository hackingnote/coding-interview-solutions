Roman to Integer
===


Problem
-------

Given a roman numeral, convert it to an integer.

The answer is guaranteed to be within the range from 1 to 3999.

Example
-------

    IV -> 4
    
    XII -> 12
    
    XXI -> 21
    
    XCIX -> 99

Note
---------

What is Roman Numeral?

- https://en.wikipedia.org/wiki/Roman_numerals
- https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
- http://baike.baidu.com/view/42061.htm

Challenge
---------

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param s Roman representation
         * @return an integer
         */
        public int romanToInt(String s) {
           
            String[] c = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M", "MM", "MMM"};
            int[] k = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000};

            int result = 0;
            while (true) {
                int i;
                for(i = c.length - 1; i>= 0; i--) {
                    if (s.startsWith(c[i])) {
                        result += k[i];
                        s = s.substring(c[i].length());
                        break;
                    }
                }
                if (s.length() == 0) {
                    break;
                }
            }
            return result;
        }
    }
