package org.mc.tests;

import org.mc.utils.MajorityElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MajorityElementTests {
    @Test(dataProvider = "majorityElement")
    public void majority_element_works(int[] array, int expectedMajorityElement) {
        int actualMajorityElement = new MajorityElement().solve(array);
        Assert.assertEquals(actualMajorityElement, expectedMajorityElement, "failed for array " + Arrays.toString(array));
    }

    @DataProvider(name="majorityElement")
    public Object[][] majorityElementProvider() {
        return new Object[][] {
                // single element array
                {
                    new int[] { 1 },
                    1
                },

                // multi element array
                {
                        new int[] { 1, 1, 1, 1, 2, 3, 7 },
                        1
                },

                {
                        new int[] { 1, 2, 1, 2, 1, 2, 1 },
                        1
                },

                {
                        new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 2 },
                        2
                },

                {
                        new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 3, 3 },
                        3
                },

                {
                        new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6},
                        6,
                },

                {
                        new int[] { 1, 1, 1, 1, 1 },
                        1
                }

        };
    }
}
