# Trailing Zeros

Write an algorithm which computes the number of trailing zeros in n factorial.  

Example

---

`11! = 39916800`, so the out should be 2

## Code(Java)

```java
class Solution {
    /*
     * param n: As description
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
};
```
