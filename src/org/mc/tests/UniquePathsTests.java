package org.mc.tests;

import org.mc.utils.UniquePaths;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UniquePathsTests {
    @Test(dataProvider = "uniquePaths")
    public void unique_paths_works(int rows, int cols, int expectedNumberOfPaths) {
        String failureMessage = "failed for " + rows + "x" + cols;

        int actualNumberOfPaths = new UniquePaths().solve(rows, cols);
        Assert.assertEquals(actualNumberOfPaths, expectedNumberOfPaths, failureMessage);
    }

    @DataProvider(name = "uniquePaths")
    public Object[][] uniquePathsProvider() {
        return new Object[][] {
                // 1x1
                { 1, 1, 1 },

                // 1x3
                { 1, 3, 1 },

                // 2x2
                { 2, 2, 2 },

                // 2x3
                { 2, 3, 3 },

                // 2x10
                { 2, 10, 10 },

                // 3x2
                { 3, 2, 3 },

                // 3x3
                { 3, 3, 6 }
        };
    }
}
