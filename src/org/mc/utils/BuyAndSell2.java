package org.mc.utils;

public class BuyAndSell2 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int last = prices[0];
        int min = prices[0];

        int maxProfit = 0;
        int currProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= last) {
                last = prices[i];
                currProfit = last - min;
            }
            else {
                maxProfit += currProfit;
                currProfit = 0;
                min = last = prices[i];
            }
        }

        return maxProfit+currProfit;
    }
}
