package org.mc.tests;

import org.mc.utils.UniquePaths2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class UniquePath2Tests {
    @Test(dataProvider = "uniquePaths2")
    public void unique_paths2_works(int[][] matrix, int expectedNOfPaths) {
        int actualNOfPaths = new UniquePaths2().solve(matrix);

        Assert.assertEquals(actualNOfPaths, expectedNOfPaths, "failed for matrix " + MatrixUtils.toMatrixString(matrix));
    }

    @DataProvider(name = "uniquePaths2")
    public Object[][] uniquePaths2Provider() {
        return new Object[][] {
                // 1 - obstacle, 0 - can pass

                // 1x1
                {
                        m(row(0)),
                        1
                },

                {
                        m(row(1)),
                        0
                },

                // 1x3
                {
                        m(row(0,0,0)),
                        1
                },

                {
                        m(row(0,1,0)),
                        0
                },

                // 2x2
                {
                        m(row(0,0),
                          row(0,0)),
                        2
                },

                {
                        m(row(0,1),
                          row(0,0)),
                        1
                },

                {
                        m(row(0,1),
                          row(1,0)),
                        0
                },

                // 2x10
                {
                        m(row(0,0,0,0,0,0,0,0,0,0),
                          row(0,0,0,0,0,0,0,0,0,0)),
                        10
                },

                {
                        m(row(0,0,0,1,0,0,0,0,0,0),
                          row(0,0,0,0,0,0,0,0,0,0)),
                        3
                },

                {
                        m(row(0,0,0,1,0,0,1,1,0,0),
                          row(0,0,0,0,0,1,0,1,0,0)),
                        0
                },

                // 3x3
                {
                        m(row(0,0,0),
                          row(0,0,0),
                          row(0,0,0)),
                        6
                },

                {
                        m(row(0,0,0),
                          row(0,1,0),
                          row(0,0,0)),
                        2
                },

                {
                        m(row(0,1,1),
                          row(0,0,0),
                          row(0,0,0)),
                        3
                }
          };
    }
}
