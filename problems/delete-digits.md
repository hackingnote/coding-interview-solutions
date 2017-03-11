Delete Digits
===

## Problem

Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.
Find the smallest integer after remove k digits.
N <= 240 and k <= N, 


## Example

Given an integer A = "178542", k = 4
return a string "12"

Code(Java)
----------

```java
public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        int[] cnt = new int[10];



        String result = "";

        for (int i = 0; i < k; i++) {
            char[] c = A.toCharArray();
            for (int j = 0; j < c.length - 1; j++) {
                if (c[j] > c[j + 1]) {
                    A = A.substring(0, j) + A.substring(j + 1);
                    break;
                }
            }
            A = A.substring(0, c.length - 1);

        }

        while(A.charAt(0) == '0') {
            A = A.substring(1);
        }


        return A;
    }
}
```