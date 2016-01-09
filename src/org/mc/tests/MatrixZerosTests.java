package org.mc.tests;

import org.mc.utils.MatrixZeroes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class MatrixZerosTests {
    @Test(dataProvider = "matrixZeros")
    public void matrix_zeros_works(int[][] matrix, int[][] expectedMatrix) {
        new MatrixZeroes().solve(matrix);

        String actual = toMatrixString(matrix);
        String expected = toMatrixString(expectedMatrix);

        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "matrixZeros")
    public Object[][] matrixZerosProvider() {
        return new Object[][] {
                // empty matrix
                {
                        m(),
                        m()
                },

                // single element matrix
                {
                        m(row(1)),
                        m(row(1))
                },

                // 3x3 matrix no zeros
                {
                        m(row(1,2,3),
                          row(4,5,6),
                          row(7,8,9)),

                        m(row(1,2,3),
                          row(4,5,6),
                          row(7,8,9)),
                },

                // 3x3 zero in center
                {
                        m(row(1,2,3),
                          row(4,0,6),
                          row(7,8,9)),

                        m(row(1,0,3),
                          row(0,0,0),
                          row(7,0,9)),
                },

                // 3x3 zeros in corners
                {
                        m(row(0,2,0),
                          row(4,5,6),
                          row(0,8,0)),

                        m(row(0,0,0),
                          row(0,5,0),
                          row(0,0,0)),
                },

                // 3x3 zeros in only 2 corners
                {
                        m(row(0,2,3),
                          row(4,5,6),
                          row(0,8,9)),

                        m(row(0,0,0),
                          row(0,5,6),
                          row(0,0,0)),
                },

                // 3x4 matrix random zeros
                {
                        m(row(1,2,3,1),
                          row(4,5,0,2),
                          row(0,8,9,7)),

                        m(row(0,2,0,1),
                          row(0,0,0,0),
                          row(0,0,0,0)),
                },

                {
                        m(row(3,2,3,1),
                          row(4,0,1,2),
                          row(2,8,9,0)),

                        m(row(3,0,3,0),
                          row(0,0,0,0),
                          row(0,0,0,0)),
                },

        };
    }


}
