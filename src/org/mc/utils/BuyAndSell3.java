package org.mc.utils;

public class BuyAndSell3 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int[] maxProfitLeft = new int[prices.length+1];

        int min = prices[0];
        maxProfitLeft[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            maxProfitLeft[i] = Math.max(maxProfitLeft[i-1], prices[i]-min);
        }

        int[] maxProfitRight = new int[prices.length+1];

        int max = prices[prices.length-1];
        maxProfitRight[0] = prices.length;
        for (int i = prices.length-2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }

            maxProfitRight[i] = Math.max(maxProfitRight[i+1], max-prices[i]);
        }

        max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, maxProfitLeft[i] + maxProfitRight[i+1]);
        }

        return max;
   }
}
