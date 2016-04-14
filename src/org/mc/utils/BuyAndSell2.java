package org.mc.utils;

public class BuyAndSell2 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int totalProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                totalProfit += Math.max(0, prices[i-1] - minPrice);
                minPrice = prices[i];
            }
        }

        // last transaction
        totalProfit += Math.max(0, prices[prices.length-1] - minPrice);

        return totalProfit;
    }

    public static int maxProfit2(int[] prices) {
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
