package org.mc.tests;

import org.mc.utils.Search2DMatrix;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search2DMatrixTests {
    private int[][] _matrix;
    private int[] _notInMatrix;

    @BeforeTest
    public void beforeTest() {
        _matrix = new int[][] {
                { 1, 5, 8, 9 },
                { 12, 14, 16, 17 },
                { 101, 113, 131, 143 }
        };

        _notInMatrix = new int[] { -1, 3, 10, 13, 22, 112, 140, 160 };
    }

    @Test
    public void search_2d_matrix_returns_indexes_of_value_when_value_exists_in_matrix() {
        for (int row = 0; row < _matrix.length; row++) {
            int[] currRow = _matrix[row];

            for (int col = 0; col < currRow.length; col++) {
                Search2DMatrix.Result result = new Search2DMatrix().solve(_matrix, currRow[col]);

                Assert.assertEquals(result.row(), row);
                Assert.assertEquals(result.col(), col);
            }
        }
    }

    @Test
    public void search_2d_matrix_returns_not_found_when_value_doesnt_exists_in_matrix() {
        for (int value : _notInMatrix) {
            Search2DMatrix.Result result = new Search2DMatrix().solve(_matrix, value);
            Assert.assertEquals(result.found(), false, "failed for value " + value);
        }
    }
}
