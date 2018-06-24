# Ugly Number

## Problem

Ugly number is a number that only have factors 3, 5 and 7.

Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...

## Example

If K=4, return 9.

## Challenge

O(K log K) or O(K) time.

## Code(Java)

```java
class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        long[] a = new long[k + 1];
        a[0] = 1;
        int i3 = 0, i5 = 0, i7 = 0;

        for (int i = 1; i <= k; i++) {
            a[i] = Collections.min(Arrays.asList(a[i3] * 3, a[i5] * 5, a[i7] * 7));
            if (a[i] % 3 == 0) i3++;
            if (a[i] % 5 == 0) i5++;
            if (a[i] % 7 == 0) i7++;
        }
        return a[k];
    }
};
```
