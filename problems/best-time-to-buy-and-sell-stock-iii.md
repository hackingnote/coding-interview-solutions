Best Time to Buy and Sell Stock III
===



Problem
-------

- [LeetCode 123](https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
- [LintCode 151](http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iii/)

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Notice

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
-------

Given an example [4,4,6,1,1,4,2,5], return 6.




Code(Java)
----------

```java
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0,
            buy2 = Integer.MIN_VALUE, sell2 = 0;
    
        for (int price : prices) {
            sell2 = Math.max(sell2, price + buy2); 
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, price + buy1);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
};

```