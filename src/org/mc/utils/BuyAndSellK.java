package org.mc.utils;

public class BuyAndSellK {
    public static int maxProfit(int[] prices, int K) {
        int[][] profit = new int[prices.length][K+1];

        // profit[i][k] - profit for trading actions from 0 to i (including)
        // using k transactions
        int minPrice = prices[0];
        int maxProfit = 0;

        profit[0][1] = 0;
        for (int end = 1; end < prices.length; end++) {
            maxProfit = Math.max(maxProfit, prices[end] - minPrice);
            minPrice = Math.min(minPrice, prices[end]);

            profit[end][1] = maxProfit;
        }

        int maxPrice;

        for (int k = 2; k <= K; k++) {
            profit[0][k] = 0;

            for (int end = 1; end < prices.length; end++) {
                maxProfit = profit[end][k-1];
                maxPrice = prices[end];

                // [0..split-1][k-1] + [split..end][1]
                for (int split = end; split > 0; split--) {
                    maxProfit = Math.max(maxProfit, profit[split-1][k-1] + maxPrice - prices[split]);
                    maxPrice = Math.max(maxPrice, prices[split]);
                }

                profit[end][k] = maxProfit;
            }
        }

        return profit[prices.length-1][K];
    }
}
