package org.mc.tests;

import org.junit.Assert;
import org.mc.utils.RemoveElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RemoveElementTests {
    @Test(dataProvider="removeElement")
    public void remove_element_works(int[] array, int elementToRemove, int[] expectedArray) {
        int newLength = new RemoveElement().solve(array, elementToRemove);
        int[] actualArray = Arrays.copyOf(array, newLength);

        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @DataProvider(name="removeElement")
    public Object[][] removeElementProvider() {
        return new Object[][] {
                // empty array
                {
                        new int[] { },
                        7,
                        new int[] { }
                },

                // remove all elements
                {
                        new int[] { 1, 1, 1, 1, 1 },
                        1,
                        new int[] { }
                },

                // remove non existing element
                {
                        new int[] { 1, 2, 3, 4, 5 },
                        666,
                        new int[] { 1, 2, 3, 4, 5 }
                },

                // remove elements
                {
                        new int[] { 1, 2, 3, 1, 2, 3 },
                        3,
                        new int[] { 1, 2, 1, 2 }
                },

                {
                        new int[] { 100, 101, 100, 100, 102 },
                        100,
                        new int[] { 101, 102 }
                },

                // remove at beginning
                {
                        new int[] { 1, 2, 3, 4, 5, 7, 8 },
                        8,
                        new int[] { 1, 2, 3, 4, 5, 7 }
                },

                // remove at end
                {
                        new int[] { 1, 2, 3, 4, 5 },
                        1,
                        new int[] { 2, 3, 4, 5 }
                }
        };
    }
}
