package org.mc.tests;

import org.mc.utils.RotateImage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class RotateImageTests {
    @Test(dataProvider = "rotateImage")
    public void rotate_image_works(int[][] matrix, int[][] rotatedMatrix) {
        matrix = matrix.clone();
        new RotateImage().rotate(matrix);

        String actualMatrix = toMatrixString(matrix);
        String expectedMatrix = toMatrixString(rotatedMatrix);

        Assert.assertEquals(actualMatrix, expectedMatrix);
    }

    @DataProvider(name = "rotateImage")
    public Object[][] rotateImageProvider() {
        return new Object[][] {
                {
                        m(row(1)),
                        m(row(1))
                },

                {
                        m(row(1,2),
                          row(3,4)),

                        m(row(3,1),
                          row(4,2))
                },

                {
                        m(row(1,2,3),
                          row(4,5,6),
                          row(7,8,9)),

                        m(row(7,4,1),
                          row(8,5,2),
                          row(9,6,3))
                }
        };
    }
}
