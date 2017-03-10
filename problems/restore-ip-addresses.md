Restore IP Addresses
====================

LintCode 426: http://www.lintcode.com/en/problem/restore-ip-addresses/

Problem
-------

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example
-------

Given "25525511135", return

```
[
  "255.255.11.135",
  "255.255.111.35"
]
```

Order does not matter.

Solution
--------


Code(Java)
----------

```java

public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        char[] raw = s.toCharArray();
        int[] digits = new int[raw.length];
        for (int i = 0; i < raw.length; i++) {
            digits[i] = raw[i] - '0';
        }
        
        ArrayList<String> result = new ArrayList<>();
        Stack<Integer> buffer = new Stack<>();
        restore(result, digits, 0, buffer);
        return result;
    }
    
    private void restore(ArrayList<String> result, int[] digits, int ptr, Stack<Integer> buffer) {
        if (buffer.size() == 4 && ptr == digits.length) {
            String s = buffer.get(0) + "." + buffer.get(1) + "." + buffer.get(2) + "." + buffer.get(3);
            result.add(s);
            return;
        }
        
        int tmp = 0;
        for (int i = 0; i < 3; i++) {
            if (ptr + i >= digits.length) break;
            if (digits[ptr] == 0 && i > 0) break;
            tmp *= 10;
            tmp += digits[ptr + i];
            if (tmp < 256) {
                buffer.add(tmp);
                restore(result, digits, ptr + i + 1, buffer);
                buffer.pop();
            }
        }
    }
}

```