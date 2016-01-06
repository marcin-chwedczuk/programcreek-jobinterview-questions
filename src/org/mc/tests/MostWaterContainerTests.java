package org.mc.tests;

import org.mc.utils.MostWaterContainer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MostWaterContainerTests {
    @Test(dataProvider = "waterContainer")
    public void most_water_container_works(int[] heights, int start, int stop) {
        MostWaterContainer.Solution actualSolution = new MostWaterContainer().solve(heights);

        Assert.assertEquals(actualSolution.getStart(), start, "incorrect start: " + actualSolution.toString());
        Assert.assertEquals(actualSolution.getStop(), stop, "incorrect stop: " + actualSolution.toString());
    }

    @DataProvider(name = "waterContainer")
    public Object[][] waterContainerTests() {
        return new Object[][] {
                // only 2 borders
                {
                        new int[] { 3, 5 },
                        0, 1
                },

                // all borders equal
                {
                        new int[] { 1, 1, 1, 1, 1 },
                        0, 4
                },

                // concave borders
                {
                        new int[] { 4, 3, 2, 3, 4 },
                        0, 4
                },

                // convex borders
                {
                        new int[] { 1, 2, 3, 3, 2, 1 },
                        1, 4
                },

                // growing
                {
                        new int[] { 1, 2, 3, 4, 5 },
                        1, 4 // or 1, 4
                },

                // shrinking
                {
                        new int[] { 5, 4, 3, 2, 1 },
                        0, 3
                },

                // various
                {
                        new int[] { 4, 5, 6, 1, 3, 6, 5 },
                        1, 6
                }
        };
    }
}
