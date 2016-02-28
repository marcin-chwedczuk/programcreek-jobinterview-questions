package org.mc.utils;

import org.testng.annotations.Test;

public class BuyAndSell1 {
    /*
     * Tested using: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else {
                maxProfit = Math.max(maxProfit, prices[i]-min);
            }
        }

        return maxProfit;
    }
}
