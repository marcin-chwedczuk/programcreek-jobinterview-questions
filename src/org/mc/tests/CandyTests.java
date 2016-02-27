package org.mc.tests;

import org.mc.utils.Candies;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CandyTests {

    @Test(dataProvider = "candy")
    public void candy_works(int[] children, int candies) {
        int actualCandies = Candies.howManyAreNeededFor(children);

        Assert.assertEquals(actualCandies, candies, "failed for: " + Arrays.toString(children));
    }

    @DataProvider(name = "candy")
    public Object[][] candyProvider() {
        return new Object[][] {
                {
                        new int[] { 10 },
                        1
                },

                {
                        new int[] { 10, 10 },
                        2
                },

                {
                        new int[] { 10, 20 },
                        3
                },

                {
                        new int[] { 20, 10 },
                        3
                },

                {
                        new int[] { 10, 20, 20 },
                        4
                },
                {
                        new int[] { 10, 20, 30, 10 },
                        7
                },

                {
                        new int[] { 40, 30, 20, 10 },
                        4+3+2+1
                },

                {
                        new int[] { 10, 20, 30, 20, 10 },
                        5+1+2+1
                },

                {
                        new int[] { 30, 20, 10, 20, 30 },
                        3+2+1+2+3
                }
        };
    }
}
