package org.mc.tests;

import org.junit.Assert;
import org.mc.utils.Utils;
import org.testng.annotations.*;

public class RotateTests {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void given_empty_array_throws_exception() {
        Utils.rotate(null, 0);
    }

    @Test(dataProvider = "rotationCounts")
    public void can_rotate_empty_array_by_specified_number_of_positions(int rotationCount) {
        String[] emptyArray = { };

        Utils.rotate(emptyArray, rotationCount);

        Assert.assertEquals(0, emptyArray.length);
    }

    @Test(dataProvider = "rotationCounts")
    public void can_rotate_single_element_array_by_specified_number_of_positions(int rotationCount) {
        String[] singleElementArray = { "foo" };

        Utils.rotate(singleElementArray, rotationCount);

        Assert.assertEquals(1, singleElementArray.length);
        Assert.assertEquals("foo", singleElementArray[0]);
    }

    @Test(dataProvider = "rotatedArray")
    public void can_rotate_given_array_by_specified_number_of_positions(Integer[] originalArray, int rotationCount, Integer[] expectedArray) {
        originalArray = originalArray.clone();

        Utils.rotate(originalArray, rotationCount);

        Assert.assertArrayEquals(expectedArray, originalArray);
    }

    @DataProvider(name = "rotationCounts")
    public Object[][] rotationCountsProvider() {
        return new Object[][] {
                { -3 },
                {  0 },
                {  5 }
        };
    }

    @DataProvider(name = "rotatedArray")
    public static Object[][] rotatedArrayProvider() {
        return new Object[][] {
                // array that is not rotated
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        0,
                        new Integer[] { 1, 2, 3, 4, 5, 6 }
                },

                // array rotated one place forward
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        1,
                        new Integer[] { 6, 1, 2, 3, 4, 5 }
                },

                // array rotated one place backward
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        -1,
                        new Integer[] { 2, 3, 4, 5, 6, 1 }
                },

                // array rotated by array.length
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        6,
                        new Integer[] { 1, 2, 3, 4, 5, 6 }
                },

                // array rotated by array.length - 1
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        5,
                        new Integer[] { 2, 3, 4, 5, 6, 1 }
                },

                // array rotated by 2*array.length + 3
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        15,
                        new Integer[] { 4, 5, 6, 1, 2, 3 }
                },

                // array rotated by some number of places backwards
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        -3,
                        new Integer[] { 4, 5, 6, 1, 2, 3 }
                },

                // array rotated by array.length backwards
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        -6,
                        new Integer[] { 1, 2, 3, 4, 5, 6 }
                },

                // array rotated by array.length + 1 backward
                {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        -7,
                        new Integer[] { 2, 3, 4, 5, 6, 1 }
                }
        };
    }
}
