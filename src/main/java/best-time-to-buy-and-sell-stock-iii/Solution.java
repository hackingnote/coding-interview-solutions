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
