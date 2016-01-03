package org.mc.tests;

import org.apache.commons.lang3.StringUtils;
import org.mc.utils.MinimumInRotatedArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MinimumInRotatedArrayTests {
    @Test(dataProvider = "rotatedArrays")
    public void minimum_in_rotated_array_works(int[] array, int expectedMinimumIndex) {
        int actualMinimumIndex = new MinimumInRotatedArray().solve(array);
        Assert.assertEquals(actualMinimumIndex, expectedMinimumIndex);
    }

    @Test(dataProvider = "rotatedArraysWithDuplicates")
    public void minimum_in_rotated_array_with_duplicates_works(int[] array, int expectedMinimum) {
        String failureMessage = "failed for array " + Arrays.toString(array);

        int actualMinimumIndex = new MinimumInRotatedArray().solveWithDuplicates(array);
        Assert.assertEquals(actualMinimumIndex, expectedMinimum, failureMessage);
    }

    @DataProvider(name="rotatedArrays")
    public Object[][] rotatedArraysProvider() {
        return new Object[][] {
                // single element array
                {
                        new int[] { 1 },
                        0
                },

                // not rotated array
                {
                        new int[] { 1, 2, 3 },
                        0
                },

                {
                        new int[] { 1, 2, 3, 4 },
                        0
                },

                // array rotated by length-1
                {
                        new int[] { 2, 3, 4, 1 },
                        3
                },

                {
                        new int[] { 2, 3, 4, 5, 1 },
                        4
                },

                // array rotated by N
                {
                        new int[] { 3, 4, 1, 2 },
                        2
                },

                {
                        new int[] { 3, 4, 5, 6, 0, 1, 2 },
                        4
                }
        };
    }

    @DataProvider(name="rotatedArraysWithDuplicates")
    public Object[][] rotatedArraysWithDuplicatesProvider() {
        return new Object[][] {
                // single value array
                {
                        new int[] { 1 },
                        0
                },

                {
                        new int[] { 1, 1 },
                        0
                },

                {
                        new int[] { 1, 1, 1 },
                        0
                },


                // not rotated array
                {
                        new int[] { 1, 2, 3 },
                        0
                },

                {
                        new int[] { 1,1, 2,2,2, 3,3 },
                        0
                },

                {
                        new int[] { 1, 2, 3, 4 },
                        0
                },

                {
                        new int[] { 1,1,1, 2, 3,3,3,3, 4,4 },
                        0
                },


                // array rotated by length-1
                {
                        new int[] { 2, 3, 4, 1 },
                        3
                },

                {
                        new int[] { 2,2, 3,3,3,3, 4,4,4, 1 },
                        9
                },

                {
                        new int[] { 2, 3, 4, 5, 1 },
                        4
                },

                {
                        new int[] { 2, 2, 3, 3, 4, 4, 5, 5, 1 },
                        8
                },

                // array rotated by N
                {
                        new int[] { 3, 4, 1, 2 },
                        2
                },

                {
                        new int[] { 3, 3, 3, 4, 1, 2, 2 },
                        4
                },

                {
                        new int[] { 3, 3, 4, 5, 6, 0, 1, 2, 3, 3 },
                        5
                },

                // special cases
                {
                        new int[] { 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, },
                        5
                }
        };
    }
}
