package org.mc.tests;

import org.mc.dataStructures.Subarray;
import org.mc.utils.MaximumSubarray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaximumSubarrayTests {
    @Test(dataProvider = "maximumSubarray")
    public void maximum_subarray_works(int[] array, int subarrayStart, int subarrayEnd) {
        Subarray subarray = MaximumSubarray.find(array);

        String failMessage = "failed for array: " + Arrays.toString(array);
        Assert.assertEquals(subarray.toString(), subarrayStart + " " + subarrayEnd, failMessage);
    }

    @DataProvider(name = "maximumSubarray")
    public Object[][] maximumSubarrayProvider() {
        return new Object[][] {
                {
                        new int[] { 1 },
                        0, 1
                },

                {
                        new int[] { 0, 0, 1, 1, 2, 0, 0 },
                        2, 5
                },

                {
                        new int[] { 1, 1, 1 },
                        0, 3
                },

                {
                        new int[] { 1, -1, 1 },
                        0, 1
                },

                {
                        new int[] { -4, -1, -2, -3, -2, -3 },
                        1, 2
                },

                {
                        new int[] { 1, 2, -4, 1, 3, -20, 3, 4, -2, 7 },
                        6, 10
                },

                {
                        new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 },
                        3, 7
                },

                {
                        new int[] { -1, -2, 5, -2 },
                        2, 3
                },

        };
    }
}
