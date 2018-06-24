# Pow(x, n)

## Problem

Implement `pow(x, n)`.

## Example

```
Pow(2.1, 3) = 9.261
Pow(0, 1) = 0
Pow(1, 0) = 1
```

## Note

You don't need to care about the precision of your answer, it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.

## Challenge

`O(logn)` time

## Code(Java)

```java
public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n > 0) {
            while (n-- > 0) {
                result *= x;
            }
            return result;
        } else {
            while (n++ < 0) {
                result *= x;
            }
            return 1 / result;
        }
    }
}
```
