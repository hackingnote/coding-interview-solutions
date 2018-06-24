# Lonely Integer

## Problem

[HackerRank: Lonely Integer](https://www.hackerrank.com/challenges/lonely-integer)

There are N integers in an array A. All but one integer occur in pairs. Your task is to find out the number that occurs only once.

## Solution

Xor: `a ^ a = 0`, `0 ^ a = 0`, `a ^ x ^ a = x`

Apply Xor to all numbers, the result will be the lonely integer.

## Code(Java)

```java
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        while (n-- > 0) {
            result ^= scanner.nextInt();
        }
        System.out.println(result);
    }
}
```
