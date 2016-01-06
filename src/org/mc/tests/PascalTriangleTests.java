package org.mc.tests;

import org.mc.utils.PascalTriangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PascalTriangleTests {
    @Test
    public void pascal_triangle_works() {
        int[][] expectedTriangle = new int[][] {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 }
        };

        int[][] actualTriangle = new PascalTriangle().solve(5);
        Assert.assertEquals(actualTriangle.length, expectedTriangle.length);

        for (int row = 0; row < actualTriangle.length; row++) {
            Assert.assertEquals(actualTriangle, expectedTriangle);
        }
    }
}
