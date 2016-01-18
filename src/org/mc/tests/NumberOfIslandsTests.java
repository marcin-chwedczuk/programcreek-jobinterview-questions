package org.mc.tests;

import org.mc.utils.NumberOfIslands;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class NumberOfIslandsTests {
    @Test(dataProvider = "numberOfIslands")
    public void number_of_islands_works(int[][] map, int expectedNOfIslands) {
        int actualNOfIslands = new NumberOfIslands().solve(map);

        Assert.assertEquals(actualNOfIslands, expectedNOfIslands, "failed for " + toMatrixString(map));
    }

    @DataProvider(name = "numberOfIslands")
    public Object[][] numberOfIslandsProvider() {
        return new Object[][] {
                {
                        m(row(1)),
                        1
                },

                {
                        m(row(0)),
                        0
                },

                {
                        m(row(0,0,0),
                          row(0,0,0),
                          row(0,0,0)),
                        0
                },

                {
                        m(row(1,0,1),
                          row(0,0,0),
                          row(1,0,1)),
                        4
                },

                {
                        m(row(1,1,0),
                          row(0,0,1),
                          row(1,1,0)),
                        3
                },

                {
                        m(row(1,0,0),
                          row(1,1,0),
                          row(1,0,0)),
                        1
                },

                {
                        m(row(1,1,1),
                          row(1,1,1),
                          row(1,1,1)),
                        1
                },

                {
                        m(row(0,0,0,1,0),
                          row(0,1,0,1,0),
                          row(1,1,0,1,0),
                          row(1,0,1,1,1)),
                        2
                }
        };
    }
}
