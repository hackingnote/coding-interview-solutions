# Plus One

## Problem

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

## Example

Given `[1,2,3]` which represents 123, return `[1,2,4]`.

Given `[9,9,9]` which represents 999, return `[1,0,0,0]`.

## Code(Java)

```java
public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if (carry == 0) {
            return result;
        } else {
            int[] finalResult = new int[result.length + 1];
            finalResult[0] = 1;
            for (int i = 0; i < result.length; i++) {
                finalResult[i + 1] = result[i];
            }
            return finalResult;
        }
    }
}
```
