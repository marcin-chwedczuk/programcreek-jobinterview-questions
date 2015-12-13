package org.mc.tests;

import org.junit.Assert;
import org.mc.utils.Utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReverseTests {
    @Test(dataProvider = "reverseArrays")
    public void reverse_reverses_array_in_place(
            Integer[] arrayToReverse,
            int startIndex, int stopIndex,
            Integer[] expectedReversedArray)
    {
        arrayToReverse = arrayToReverse.clone();

        Utils.reverse(arrayToReverse, startIndex, stopIndex);

        Assert.assertArrayEquals(arrayToReverse, expectedReversedArray);
    }

    @DataProvider(name = "reverseArrays")
    public Object[][] reverseArraysProvider() {
        return new Object[][] {
                // REVERSE WHOLE ARRAY
                // empty array
                {
                        new Integer[] { },
                        0, 0,
                        new Integer[] { }
                },

                // single element array
                {
                        new Integer[] { 1 },
                        0, 1,
                        new Integer[] { 1 }
                },

                // array with even number of elements
                {
                        new Integer[] { 1, 2, 3, 4 },
                        0, 4,
                        new Integer[] { 4, 3, 2, 1 }
                },

                // array with odd number of elements
                {
                        new Integer[] { 1, 2, 3, 4, 5 },
                        0, 5,
                        new Integer[] { 5, 4, 3, 2, 1 }
                },

                // REVERSE PART OF THE ARRAY
                // empty part
                {
                        new Integer[] { 1, 2, 3, 4 },
                        2, 2,
                        new Integer[] { 1, 2, 3, 4 }
                },

                // reverse beginning
                {
                        new Integer[] { 1, 2, 3, 100, 200, 300 },
                        0, 3,
                        new Integer[] { 3, 2, 1, 100, 200, 300 }
                },

                // reverse ending
                {
                        new Integer[] { 100, 200, 300, 1, 2, 3 },
                        3, 6,
                        new Integer[] { 100, 200, 300, 3, 2, 1 }
                },

                // reverse in the middle
                {
                        new Integer[] { 100, 200, 1, 2, 3, 4, 5, 300, 400 },
                        2, 7,
                        new Integer[] { 100, 200, 5, 4, 3, 2, 1, 300, 400 }
                }
        };
    }
}
