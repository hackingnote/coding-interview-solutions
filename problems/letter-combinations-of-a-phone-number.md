# Letter Combinations Of A Phone Number

## Problem

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

## Example

Given `23`

Return `["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]`

## Note

Although the above answer is in lexicographical order, your answer could be in any order you want.

## Code(Java)

```java
public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");

        String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        char[] c = digits.toCharArray();
        for (int i = 0; i < c.length; i++) {
            String s = map[c[i] - '0'];
            ArrayList<String> tmp = new ArrayList<>();
            for (char letter : s.toCharArray()) {
                for (String str : result) {
                    tmp.add(str + letter);
                }
            }
            result = tmp;
        }
        Collections.sort(result);
        return result;
    }
}
```
