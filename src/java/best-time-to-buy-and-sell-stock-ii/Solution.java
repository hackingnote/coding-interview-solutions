public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int buyIndex = 0;
        int sellIndex = 0;

        while(true) {

            while(buyIndex + 1 < prices.length && prices[buyIndex] > prices[buyIndex + 1]) {
                buyIndex++;
            }

            sellIndex = buyIndex + 1;

            while(sellIndex + 1 < prices.length && prices[sellIndex] < prices[sellIndex+1]) {
                sellIndex++;
            }

            if (sellIndex >=prices.length || buyIndex >= prices.length) {
                break;
            }
            sum+=prices[sellIndex] - prices[buyIndex];

            buyIndex = sellIndex + 1;
        }

        return sum;
    }
}

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        
        int sum = 0;
        int buyIndex = 0;
        int sellIndex = 0;

        while(true) {

            while(buyIndex + 1 < prices.length && prices[buyIndex] > prices[buyIndex + 1]) {
                buyIndex++;
            }

            sellIndex = buyIndex + 1;

            while(sellIndex + 1 < prices.length && prices[sellIndex] < prices[sellIndex+1]) {
                sellIndex++;
            }

            if (sellIndex >=prices.length || buyIndex >= prices.length) {
                break;
            }
            sum+=prices[sellIndex] - prices[buyIndex];

            buyIndex = sellIndex + 1;
        }

        return sum;
    
    }
};
