package org.mc.tests;

import org.mc.dataStructures.Subarray;
import org.mc.utils.MaximumProductSubarray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaximumProductSubarrayTests {
    @Test(dataProvider = "maximumProduct")
    public void maximum_product_subarray_works(int[] array, int subarrayStart, int subarrayEnd) {
        Subarray maxSubarray = MaximumProductSubarray.find(array);

        Assert.assertEquals(maxSubarray.toString(), subarrayStart + " " + subarrayEnd,
                "failed for array: " + Arrays.toString(array));
    }

    @DataProvider(name = "maximumProduct")
    public Object[][] maximumProductProvider() {
        return new Object[][] {
                {
                        new int[] { 1 },
                        0, 1
                },

                {
                        new int[] { -3 },
                        0, 1
                },

                {
                        new int[] { 1, 2, 3 },
                        0, 3
                },

                {
                        new int[] { -1, -2, -3 },
                        1, 3
                },

                {
                        new int[] { -1, -2, -3, -4 },
                        0, 4
                },

                {
                        new int[] { -4, 1, 2, 3, -1 },
                        0, 5
                },

                {
                        new int[] { -3, 1, -3, 2, -4, 1, 2 },
                        1, 7
                },

                {
                        new int[] { 2, -2, 2, -2, 2, -2, 2 },
                        0, 5
                },

                {
                        new int[] { 1, 2, 1, 3, -3, 2, 3, 2 },
                        5, 8
                },

                {
                        new int[] { 2, 3, -2, 4 },
                        0, 2
                },

                {
                        new int[] { 5, -2, 0, -1, -2, 5, -2, 0, 3, -2, -2 },
                        4, 7
                },

                {
                        new int[] { 0, 7, 0, 9, 0, 11, 0 },
                        5, 6
                },

                {
                        new int[] { 0, 0, 0, 0 },
                        0, 1
                }
        };
    }
}
