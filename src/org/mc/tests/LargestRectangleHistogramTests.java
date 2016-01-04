package org.mc.tests;

import org.mc.utils.LargestRectangleHistogram;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class LargestRectangleHistogramTests {
    @Test(dataProvider="largeRectangles")
    public void largest_rectangle_histogram_works(int[] histogram, int expectedLargestRectangleSize) {
        int actualLargestRectangleSize = new LargestRectangleHistogram().solve(histogram);

        Assert.assertEquals(
                actualLargestRectangleSize,
                expectedLargestRectangleSize,
                "failed for array " + Arrays.toString(histogram));
    }

    @DataProvider(name="largeRectangles")
    public Object[][] largeRectanglesProvider() {
        return new Object[][] {
                // single stripe
                {
                        new int[] { 5 },
                        5
                },

                // one big rectangle
                {
                        new int[] { 3, 3, 3, 3, 3 },
                        15
                },

                // two rectangles
                {
                        new int[] { 5,5,5, 0, 5,5,5 },
                        15
                },

                // real test cases
                {
                        new int[] { 1, 2, 3, 4, 5 },
                        9
                },

                {
                        new int[] { 5, 4, 3, 2, 1 },
                        9
                },

                {
                        new int[] { 3,2,1,2,3 },
                        5
                },

                {
                        new int[] { 1, 2, 1, 3, 1 },
                        5
                },

                {
                        new int[] { 2, 1, 5, 6, 2, 3 },
                        10
                },

                {
                        new int[] { 2, 7, 5, 3, 7, 4, 7 },
                        18
                },

                {
                        new int[]{6, 2, 5, 4, 5, 1, 6},
                        12
                }
        };
    }
}
