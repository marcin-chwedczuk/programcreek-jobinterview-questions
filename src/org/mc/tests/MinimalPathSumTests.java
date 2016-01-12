package org.mc.tests;

import org.apache.commons.lang3.StringUtils;
import org.mc.utils.MinimalPathSum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;
import java.util.List;

public class MinimalPathSumTests {
    @Test(dataProvider = "minimalPathSum")
    public void minimal_path_sum_works(int[][] matrix, String expectedPath) {
        List<MinimalPathSum.Coords> actualPathCoords =
                new MinimalPathSum().findPath(matrix);

        String actualPath = StringUtils.join(actualPathCoords, " ");
        Assert.assertEquals(actualPath, expectedPath, "failed for matrix: " + MatrixUtils.toMatrixString(matrix));
    }

    @DataProvider(name = "minimalPathSum")
    public Object[][] minimalPathSumProvider() {
        return new Object[][] {
                // base cases
                {
                        m(row(1)),
                        "0,0"
                },

                {
                        m(row(1,2),
                          row(5,3)),

                        "0,0 0,1 1,1"
                },

                // 3x3 paths
                {
                        m(row(3,2,1),
                          row(5,4,1),
                          row(2,3,1)),

                        "0,0 0,1 0,2 1,2 2,2"
                },
                {
                        m(row(3,2,9),
                          row(1,1,9),
                          row(7,3,7)),

                        "0,0 1,0 1,1 2,1 2,2"
                },

                // 6x6 path
                {
                          m(row(1,0,0,0,0,0,1),
                            row(0,1,1,1,1,0,0),
                            row(0,1,0,0,0,1,1),
                            row(0,0,0,1,0,1,1),
                            row(1,0,1,0,0,1,1),
                            row(1,0,1,0,0,0,0)),

                        "0,0 1,0 2,0 3,0 3,1 3,2 2,2 2,3 2,4 3,4 4,4 5,4 5,5 5,6"
                }
        };
    }
}
