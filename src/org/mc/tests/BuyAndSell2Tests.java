package org.mc.tests;

import org.mc.utils.BuyAndSell1;
import org.mc.utils.BuyAndSell2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BuyAndSell2Tests {
    @Test(dataProvider = "buyAndSell2")
    public void buy_and_sell2_works(int[] prices, int expectedProfit) {
        int actualProfit = BuyAndSell2.maxProfit(prices);
        Assert.assertEquals(actualProfit, expectedProfit, "failed for: " + Arrays.toString(prices));
    }

    @DataProvider(name = "buyAndSell2")
    public Object[][] buyAndSell2Provider() {
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
                        new int[] { 1, 2, 3, 2, 1, 3 },
                        4
                },

                {
                        new int[] { 1, 2, 3, 4, 2, 1, 2, 3, 4, 5, 4, 3, 2, 1, 2 },
                        8
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
                        new int[] { 1, 2, 1, 2, 1, 2 },
                        3
                }
        };
    }
}
