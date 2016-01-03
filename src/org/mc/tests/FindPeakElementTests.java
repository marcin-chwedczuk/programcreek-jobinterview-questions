package org.mc.tests;

import org.mc.utils.FindPeakElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FindPeakElementTests {
    @Test(dataProvider="findPeakElement")
    public void find_peak_element_works(int[] array, int expectedPeakIndex) {
        int actualPeakIndex = new FindPeakElement().solve(array);
        Assert.assertEquals(actualPeakIndex, expectedPeakIndex, "failed for array " + Arrays.toString(array));
    }

    @DataProvider(name="findPeakElement")
    public Object[][] findPeakElementProvider() {
        return new Object[][] {
                // flat array
                {
                        new int[] { 1,1,1,1 },
                        -1
                },

                // concave array
                {
                        new int[] { 100, 80, 60, 80, 100 },
                        0
                },

                // convex array
                {
                        new int[] { 100, 110, 120, 110 },
                        2
                },

                // random arrays
                {
                        new int[] { 2, 3, 5, 3, 2, 1, 3, 1 },
                        2
                },

                {
                        new int[] { 3, 2, 5, 3 },
                        0
                }
        };
    }
}
