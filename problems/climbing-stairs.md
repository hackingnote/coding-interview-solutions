Climbing Stairs
===


Problem
-------

[LeetCode 70](https://oj.leetcode.com/problems/climbing-stairs/)

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Key Point
---------

Store the result in a list or array, otherwise it will TLE.


Code(Java)
----------

```java
public class Solution {
    private List<Integer> cnt = new ArrayList<Integer>();

    public Solution() {
        cnt.add(0);
        cnt.add(1);
        cnt.add(2);
    }

    public int climbStairs(int n) {
        int size = cnt.size();
        if (n < size) {
            return cnt.get(n);
        }

        for (int i = size; i <= n; i++) {
            cnt.add(cnt.get(i - 1) + cnt.get(i - 2));
        }
        return cnt.get(n);
    }
}

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a;
    }
}

```