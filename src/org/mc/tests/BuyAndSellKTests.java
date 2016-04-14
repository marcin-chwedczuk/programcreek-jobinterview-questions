package org.mc.tests;

import org.mc.utils.BuyAndSell3;
import org.mc.utils.BuyAndSellK;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BuyAndSellKTests {
    @Test(dataProvider = "buyAndSellK")
    public void buy_and_sellK_works(int[] prices, int K, int expectedProfit) {
        int actualProfit = BuyAndSellK.maxProfit(prices, K);
        Assert.assertEquals(actualProfit, expectedProfit,
                "failed for: " + Arrays.toString(prices) + " and K: " + K);
    }

    @DataProvider(name = "buyAndSellK")
    public Object[][] buyAndSellKProvider() {
        return new Object[][]{
                {
                        new int[] { 1, 2, 3, 4, 2 },
                        1, 3
                },

                {
                        new int[] { 5, 1, 7, 3 },
                        1, 6
                },

                {
                        new int[] { 1, 2, 1, 2, 1, 2 },
                        2, 2
                },

                {
                        new int[] { 1,2, 1,2, 1,2 },
                        3, 3
                },

                {
                        new int[] { 1,3, 1,2, 1,5, 1,4, 1,7 },
                        3, 13
                },

                {
                        // two transactions
                        new int[]{1, 2, 3, 2, 1, 3},
                        2, 4
                },

                {
                        // three transactions pick two
                        new int[]{1, 2, 3, 1, 2, 5, 1, 2},
                        2, 2 + 4
                },

                {
                        new int[]{1, 2, 3, 4, 2, 1, 2, 3, 4, 5, 4, 3, 2, 1, 2},
                        2, 3 + 4
                },

                {
                        new int[]{3, 1, 1, 1},
                        3, 0
                },

                {
                        new int[]{1, 1, 1, 3},
                        2, 2
                },

                {
                        new int[]{1, 2, 1, 3, 1, 2},
                        2, 3
                },

                {
                        new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0},
                        2, 13
                }
        };
    }
}
