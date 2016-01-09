package org.mc.tests;

import org.mc.utils.SpiralMatrix2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class SpiralMatrix2Tests {
    @Test(dataProvider = "spiralMatrix2")
    public void spiral_matrix2_works(int n, int[][] expectedMatrix) {
        int[][] actualMatrix = new SpiralMatrix2().solve(n);

        String expected = toMatrixString(expectedMatrix);
        String actual = toMatrixString(actualMatrix);

        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "spiralMatrix2")
    public Object[][] spiralMatrix2Provider() {
        return new Object[][] {
                {
                        0,
                        m()
                },

                {
                        1,
                        m(row(1))
                },

                {
                        2,
                        m(row(1,2),
                          row(4,3))
                },

                {
                        3,
                        m(row(1,2,3),
                          row(8,9,4),
                          row(7,6,5)),
                },

                {
                        4,
                        m(row(1,2,3,4),
                          row(12,13,14,5),
                          row(11,16,15,6),
                          row(10,9,8,7))
                }
        };
    }
}
