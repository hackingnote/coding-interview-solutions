# Integer to Roman

## Problem

Given an integer, convert it to a roman numeral.

The number is guaranteed to be within the range from 1 to 3999.

## Example

```
4 -> IV
12 -> XII
21 -> XXI
99 -> XCIX
```

More examples at: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm

## Note

What is Roman Numeral?

- https://en.wikipedia.org/wiki/Roman_numerals
- https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
- http://baike.baidu.com/view/42061.htm

## Code(Java)

```java
public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        int[] s = new int[4];
        for (int i = 0; i < 4; i++) {
            s[i] = n % 10;
            n /= 10;
        }

        String[][] map = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};

        String result = "";

        int k = 3;
        while (s[k] == 0) k--;

        while (k >= 0) {
            result += map[k][s[k]];
            k--;
        }
        return result;
    }
}
```
