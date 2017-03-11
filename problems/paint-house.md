Paint House
===========

LintCode 515: http://www.lintcode.com/en/problem/paint-house/

Problem
-------

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, ``costs[0][0]`` is the cost of painting house 0 with color red; ``costs[1][2]`` is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.


Notice: All costs are positive integers.

Have you met this question in a real interview?

Example
-------

Given ``costs = [[14,2,11],[11,14,5],[14,3,10]]`` return 10

house 0 is blue, house 1 is green, house 2 is blue, ``2 + 5 + 3 = 10``

Solution
--------


Code(Java)
----------

```java

public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int[][] sum = new int[n][3];
        for (int i = 0; i < 3; i++) {
            sum[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k && sum[i - 1][k] < min) {
                        min = sum[i - 1][k];
                    }
                }
                sum[i][j] = min + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, sum[n - 1][i]);
        }
        return min;
    }
}

```