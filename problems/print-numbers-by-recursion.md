Print Numbers by Recursion
===

## Problem

Print numbers from 1 to the largest number with N digits by recursion.

 Notice
It's pretty easy to do recursion like:
recursion(i) {
    if i > largest number:
        return
    results.add(i)
    recursion(i + 1)
}

however this cost a lot of recursion memory as the recursion depth maybe very large. Can you do it in another way to recursive with at most N depth?



## Example

Given N = 1, return [1,2,3,4,5,6,7,8,9].
Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].

Code(Java)
----------

```java
public class Solution {
    /**
     * @param n: An integer.
     *           return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {

        // write your code here
        List<Integer> result = new ArrayList<>();

        if (n == 0) return result;

        int[] base = new int[n];
        base[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            base[i] = base[i + 1] * 10;
        }
        for (int i = 0; i < 10; i++) {
            recursion(result, base, base[0] * i, 0);
        }
        return result;
    }

    private void recursion(List<Integer> result, int[] base, int s, int digit) {
        if (digit == base.length - 1) {
            if (s != 0) {
                result.add(s);
            }
            return;

        }

        for (int i = 0; i < 10; i++) {
            recursion(result, base, s + base[digit + 1] * i, digit + 1);
        }
    }
}
```