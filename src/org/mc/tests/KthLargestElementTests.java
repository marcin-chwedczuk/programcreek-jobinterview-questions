package org.mc.tests;

import org.mc.utils.KthLargestElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class KthLargestElementTests {
    @Test(dataProvider = "kthLargestElement")
    public void kth_largest_element_works(int[] array, int kth, int expectedElement) {
        String failureMessage = "failed for array " + Arrays.toString(array) +
                " and element " + kth;

        int actualElement = new KthLargestElement().solve(array, kth);
        Assert.assertEquals(actualElement, expectedElement, failureMessage);
    }

    @DataProvider(name = "kthLargestElement")
    public Object[][] kthLargestElementProvider() {
        return new Object[][] {
                // boundary conditions
                {
                        new int[] { 1 },
                        1,
                        1
                },

                // sorted array
                {
                        new int[] { 1, 2, 3, 4, 5, 6, 7 },
                        1,
                        7
                },

                {
                        new int[] { 1, 2, 3, 4, 5, 6, 7 },
                        3,
                        5
                },

                {
                        new int[] { 1, 2, 3, 4, 5, 6, 7 },
                        7,
                        1
                },

                // array sorted in reverse order
                {
                        new int[] { 7, 6, 5, 4, 3, 2, 1 },
                        1,
                        7
                },

                {
                        new int[] { 7, 6, 5, 4, 3, 2, 1 },
                        3,
                        5
                },

                {
                        new int[] { 7, 6, 5, 4, 3, 2, 1 },
                        7,
                        1
                },

                // array with repetitions
                {
                        new int[] { 2, 2, 2, 2 },
                        3,
                        2
                },

                {
                        new int[] { 1, 2, 2, 1, 1, 3 },
                        3,
                        2
                },

                // random arrays
                {
                        new int[] { 5, 3, 1, 3, 6, 34 },
                        3,
                        5
                },

                {
                        new int[] { 5, 3, 2, 32, 54, 52 },
                        1,
                        54
                },

                {
                        new int[] { 3, 2, 1, 6, 4, 2 },
                        6,
                        1
                }
        };
    }
}
