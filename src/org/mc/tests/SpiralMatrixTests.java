package org.mc.tests;

import org.mc.utils.SpiralMatrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mc.tests.MatrixUtils.*;

public class SpiralMatrixTests {
    @Test(dataProvider = "spiralMatrix")
    public void spiral_matrix_works(int[][] matrix, int[] expectedOrder) {
        int[] actualOrder = new SpiralMatrix().solve(matrix.clone());

        Assert.assertEquals(actualOrder, expectedOrder,
                "failed for matrix " + toMatrixString(matrix) +
                " expected " + Arrays.toString(expectedOrder) +
                " actual " + Arrays.toString(actualOrder));
    }

    @DataProvider(name = "spiralMatrix")
    public Object[][] spiralMatrixProvider() {
        return new Object[][] {
                // boundary cases
                {
                        m(row(1)),
                        new int[] { 1 }
                },

                // single row
                {
                        m(row(1,2,3,4)),
                        new int[] { 1, 2, 3, 4 }
                },

                // single column
                {
                        m(row(1),
                          row(2),
                          row(3),
                          row(4)),
                        new int[] { 1, 2, 3, 4 }
                },

                // two rows
                {
                        m(row(1,2,3,4),
                          row(11,12,13,14)),
                        new int[] { 1,2,3,4, 14,13,12,11 }
                },

                // two columns
                {
                        m(row(1,11),
                          row(2,12),
                          row(3,13),
                          row(4,14)),

                        new int[] { 1, 11, 12, 13, 14, 4, 3, 2 }
                },

                // square matrix
                {
                        m(row(1,2,3),
                          row(4,5,6),
                          row(7,8,9)),
                        new int[] { 1,2,3,6,9,8,7,4,5 }
                },

                {
                        m(row(1,2,3,4),
                          row(5,6,7,8),
                          row(9,10,11,12),
                          row(13,14,15,16)),
                        new int[] { 1,2,3,4, 8,12,16,15,14,13, 9,5, 6,7,11,10 }
                },

                // rectangular matrix
                {
                        m(row(1,2,3,4),
                          row(5,6,7,8),
                          row(9,10,11,12)),
                        new int[] { 1,2,3,4,8,12,11,10,9,5,6,7 }
                },

                {
                        m(row(1,2,3),
                          row(5,6,7),
                          row(9,10,11),
                          row(13,14,15)),
                        new int[] { 1,2,3,7,11,15,14,13,9,5,6,10 }
                },
        };
    }
}
