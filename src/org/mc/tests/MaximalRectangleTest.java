package org.mc.tests;

import org.mc.utils.MaximalRectangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mc.tests.MatrixUtils.*;

public class MaximalRectangleTest {
    @Test(dataProvider = "maximalRectangle")
    public void maximal_rectangle_works(char matrix[][], int expectedMaximalRectangleSize) {
        int actualMaximalRectangleSize = new MaximalRectangle(matrix).solve();

        Assert.assertEquals(actualMaximalRectangleSize, expectedMaximalRectangleSize,
                "failed for matrix: " + toMatrixString(matrix));
    }

    @DataProvider(name = "maximalRectangle")
    public Object[][] maximalRectangleDataProvider() {
        return new Object[][] {
                // border cases
                {
                        cm("0"),
                        0
                },

                {
                        cm("1"),
                        1
                },

                {
                        cm("11",
                           "11"),
                        4
                },

                // 3x3 shapes
                {
                        cm("111",
                           "111",
                           "111"),
                        9
                },
                {
                        cm("111",
                           "101",
                           "101"),
                        3
                },
                {
                        cm("010",
                           "111",
                           "110"),
                        4
                },

                // 7x8 shapes
                {
                        cm("0000000",
                           "0000000",
                           "0000000",
                           "0000000",
                           "0000000",
                           "0000000",
                           "0000000",
                           "0000000"),
                        0
                },

                {
                        cm("0000011",
                           "0110011",
                           "0110000",
                           "0111110",
                           "0011110",
                           "0011110",
                           "0000100",
                           "0001111"),
                        12
                },

                {
                        cm("1010101",
                           "0101010",
                           "1010101",
                           "0101010",
                           "1010101",
                           "0101010",
                           "1010101",
                           "0101010"),
                        1
                },

                {
                        cm("0000000",
                           "0011100",
                           "0011000",
                           "0111000",
                           "1000011",
                           "1110011",
                           "1110000",
                           "1111110"),
                        9
                },

                {
                        cm("1111111",
                           "1000001",
                           "1000001",
                           "1011001",
                           "1011001",
                           "1000001",
                           "1000001",
                           "1111111"),
                        8
                },

                {
                        cm("1100000",
                           "1110000",
                           "0111000",
                           "0011100",
                           "0001110",
                           "0000111",
                           "0000011",
                           "0000000"),
                        4
                }
        };
    }
}
