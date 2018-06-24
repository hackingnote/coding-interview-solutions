# Best Time to Buy and Sell Stock II

## Problem

[LeetCode 122](https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

Say you have an array for which the `i`th element is the price of a given stock on day `i`.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

## Example

Given an example `[2,1,2,0,1]`, return 2

## Solution

Greedy.

## Code(Java)

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int buyIndex = 0;
        int sellIndex = 0;

        while (true) {

            while (buyIndex + 1 < prices.length && prices[buyIndex] > prices[buyIndex + 1]) {
                buyIndex++;
            }

            sellIndex = buyIndex + 1;

            while (sellIndex + 1 < prices.length && prices[sellIndex] < prices[sellIndex + 1]) {
                sellIndex++;
            }

            if (sellIndex >= prices.length || buyIndex >= prices.length) {
                break;
            }
            sum += prices[sellIndex] - prices[buyIndex];

            buyIndex = sellIndex + 1;
        }

        return sum;
    }
}
```

```java
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {

        int sum = 0;
        int buyIndex = 0;
        int sellIndex = 0;

        while (true) {

            while (buyIndex + 1 < prices.length && prices[buyIndex] > prices[buyIndex + 1]) {
                buyIndex++;
            }

            sellIndex = buyIndex + 1;

            while (sellIndex + 1 < prices.length && prices[sellIndex] < prices[sellIndex + 1]) {
                sellIndex++;
            }

            if (sellIndex >= prices.length || buyIndex >= prices.length) {
                break;
            }
            sum += prices[sellIndex] - prices[buyIndex];

            buyIndex = sellIndex + 1;
        }
        return sum;
    }
}
```
