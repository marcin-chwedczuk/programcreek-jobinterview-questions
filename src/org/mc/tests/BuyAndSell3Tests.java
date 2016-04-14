package org.mc.tests;

import org.mc.utils.BuyAndSell2;
import org.mc.utils.BuyAndSell3;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BuyAndSell3Tests {
    @Test(dataProvider = "buyAndSell3")
    public void buy_and_sell3_works(int[] prices, int expectedProfit) {
        int actualProfit = BuyAndSell3.maxProfit(prices);
        Assert.assertEquals(actualProfit, expectedProfit, "failed for: " + Arrays.toString(prices));
    }

    @DataProvider(name = "buyAndSell3")
    public Object[][] buyAndSell3Provider() {
        return new Object[][] {
                {
                        new int[] { },
                        0
                },

                {
                        new int[] { 1 },
                        0
                },

                {
                        // two transactions
                        new int[] { 1, 2, 3, 2, 1, 3 },
                        4
                },

                {
                        // three transactions pick two
                        new int[] { 1, 2, 3, 1, 2, 5, 1, 2 },
                        2+4
                },

                {
                        new int[] { 1, 2, 3, 4, 2, 1, 2, 3, 4, 5, 4, 3, 2, 1, 2 },
                        3+4
                },

                {
                        new int[] { 3, 1, 1, 1 },
                        0
                },

                {
                        new int[] { 1, 1, 1, 3 },
                        2
                },

                {
                        new int[] { 1, 2, 1, 3, 1, 2 },
                        3
                },

                {
                        new int[] { 1,2,4,2,5,7,2,4,9,0 },
                        13
                }
        };
    }
}
