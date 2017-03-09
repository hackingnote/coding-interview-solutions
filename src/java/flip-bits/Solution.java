Flip Bits
===



Problem 1: 32-bit integer
-------

Determine the number of bits required to flip if you want to convert integer n to integer m.

Example
-------

Given n = 31 (11111), m = 14 (01110), return 2.

Note
----

Both n and m are 32-bit integers

Code
----

```java
class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int cnt = 0;
        while (c != 0) {
            c &= c-1;
            cnt++;
        }
        return cnt;
    }
};
```

Problem 2: unsigned 32-bit integer
-------------------------

Given a list of 32 bits unsigned integers. You are required to output the list of the unsigned integers you get by flipping bits in its binary representation (i.e. unset bits must be set, and set bits must be unset).


Solution
--------

Java does not have unsigned integers, use long instead; for the lowest 32 bits:

* take the lowest bit: k & 1
* flip: k & 1 ^ 1
* add up as power of 2
* shift k to right by 1

Code
----

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            long k = scanner.nextLong();
            long s = 0;
            long b = 1;
            for (int i = 0; i < 32; i++) {
                s += (k & 1 ^ 1) * b;
                b *= 2;
                k = k >> 1;
            }
            System.out.println(s);
        }
    }
}
```
    